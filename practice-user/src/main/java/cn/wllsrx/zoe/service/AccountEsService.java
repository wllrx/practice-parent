package cn.wllsrx.zoe.service;

import cn.gjing.tools.common.util.BeanUtils;
import cn.gjing.tools.common.util.EncryptionUtils;
import cn.wllsrx.zoe.domain.vo.AccountVO;
import cn.wllsrx.zoe.entity.Account;
import cn.wllsrx.zoe.repository.AccountRepository;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.metrics.InternalAvg;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * @author zoe
 */
@Service
@Slf4j
public class AccountEsService {
    @Resource
    private AccountRepository repository;


    /**
     * mq添加账户
     */
    @RabbitListener(queues = "test")
    public void saveAccounts(List<AccountVO> accounts, Message message, Channel channel) {
        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info("[listenerAutoAck 监听的消息] - [{}]", accounts);
            List<Account> accountList = new ArrayList<>();
            for (AccountVO accountVO : accounts) {
                accountList.add(BeanUtils.copyProperties(accountVO, Account.class));
            }
            if (accountList.size() != 0) {
                this.repository.saveAll(accountList);
            }
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                channel.basicRecover();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 添加es
     */
    public void saveAccount() {
        List<Account> accounts = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Account account = Account.builder()
                    .userName("管理员"+i)
                    .userPwd(EncryptionUtils.encodeMd5("admin"+i))
                    .userPhone("1256985544"+i)
                    .build();
            account.setId(9+i);
            account.setCreateTime(new Date());
            account.setUpdateTime(new Date());
            accounts.add(account);
        }

        this.repository.saveAll(accounts);
    }

    /**
     * 查询账户
     *
     * BoolQueryBuilder builder = new BoolQueryBuilder();
     * @param userName 用户名
     * @return 账户列表
     */
    public List<Account> findAccount(String userName) {
      /*
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withHighlightFields(HighlightBuilder.Field)
                .withQuery(QueryBuilders.matchQuery("userName", userName))
                .withIndices("practice")
                .withTypes("account")
                //查询指定字段
                //.withFields("userName", "userPwd", "userPhone")
                .withPageable(PageRequest.of(0, 10))
                .build();
        Page<Account> search = this.repository.search(searchQuery);

        return search.getContent();*/
        return null;
    }

    /**
     * 删除所有账号
     */
    public void deleteAccount() {
        this.repository.deleteAll();
    }

    /**
     * AggregationBuilders：聚合的构建工厂类。所有聚合都由这个类来构建
     * （1）统计某个字段的数量
     * ValueCountBuilder vcb=  AggregationBuilders.count("count_nickname").field("nickname");
     * （2）去重统计某个字段的数量（可能有部分误差）
     * CardinalityBuilder cb= AggregationBuilders.cardinality("distinct_count_name").field("nickname");
     * （3）聚合过滤
     * FilterAggregationBuilder fab= AggregationBuilders.filter("name_filter").filter(QueryBuilders.queryStringQuery("nickname:刘德华"));
     * （4）按某个字段分组
     * TermsBuilder tb=  AggregationBuilders.terms("group_name").field("name");
     * （5）求和
     * SumBuilder  sumBuilder= AggregationBuilders.sum("sum_price").field("price");
     * （6）求平均
     * AvgBuilder ab= AggregationBuilders.avg("avg_price").field("price");
     * （7）求最大值
     * MaxBuilder mb= AggregationBuilders.max("max_price").field("price");
     * （8）求最小值
     * MinBuilder min= AggregationBuilders.min("min_price").field("price");
     * （9）按日期间隔分组
     * DateHistogramBuilder dhb= AggregationBuilders.dateHistogram("dh").field("date");
     * （10）获取聚合里面的结果
     * TopHitsBuilder thb=  AggregationBuilders.topHits("top_result");
     * （11）嵌套的聚合
     * NestedBuilder nb= AggregationBuilders.nested("negsted_path").path("quests");
     * （12）反转嵌套
     * AggregationBuilders.reverseNested("res_negsted").path("kps ");
     *
     * @param column column
     */
    public void aggregateQuery(String column) {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));
        // 添加一个新的聚合，聚合类型为terms，聚合名称为列明，列名称为
        queryBuilder.addAggregation(
                AggregationBuilders.terms(column).field(column));
        //使用给定名称创建新的聚合 AggregationBuilders.histogram("")
        HistogramAggregationBuilder histogram = AggregationBuilders.histogram("");
        System.out.println(histogram);
        AdjacencyMatrixAggregationBuilder builder = AggregationBuilders.adjacencyMatrix("", new HashMap<>());
        String type = builder.getType();
        System.out.println(type);
       // WeightedAvgAggregationBuilder weightedAvgAggregationBuilder = AggregationBuilders.weightedAvg("");
        
        //将查询结果转换为聚合分页查询
        AggregatedPage<Account> aggPage = (AggregatedPage<Account>) this.repository.search(queryBuilder.build());
        StringTerms agg = (StringTerms) aggPage.getAggregation(column);
        List<StringTerms.Bucket> buckets = agg.getBuckets();
        // 3.3、遍历
        for (StringTerms.Bucket bucket : buckets) {
            // 3.4、获取桶中的key，即列名称
            System.out.println(bucket.getKeyAsString());
            // 3.5、获取桶中的某列的数量
            System.out.println(bucket.getDocCount());
        }

    }

    public void aggregateAvg(String columnName) {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));
        queryBuilder.addAggregation(AggregationBuilders.terms(columnName).field(columnName).subAggregation(AggregationBuilders.avg("ageAvg").field("age")));
        AggregatedPage<Account> aggPage = (AggregatedPage<Account>) repository.search(queryBuilder.build());
        StringTerms agg = (StringTerms) aggPage.getAggregation(columnName);
        // 3.2、获取桶
        List<StringTerms.Bucket> buckets = agg.getBuckets();
        // 3.3、遍历
        for (StringTerms.Bucket bucket : buckets) {
            System.out.println(bucket.getKeyAsString() + ",共" + bucket.getDocCount() + "编");
            // 3.6.获取子聚合结果：
            InternalAvg avg = (InternalAvg) bucket.getAggregations().asMap().get("ageAvg");
            System.out.println("平均售价：" + avg.getValue());
        }
    }



}

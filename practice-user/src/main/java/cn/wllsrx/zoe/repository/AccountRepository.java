package cn.wllsrx.zoe.repository;

import cn.wllsrx.zoe.domain.entity.Account;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zoe
 **/
@Repository
public interface AccountRepository extends ElasticsearchRepository<Account,Integer> {

}

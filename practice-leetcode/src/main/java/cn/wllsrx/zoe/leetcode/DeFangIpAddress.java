package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * IP 地址无效化
 * <p>
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * <p>
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * <p>
 * 提示：
 * <p>
 * 给出的 address 是一个有效的 IPv4 地址
 **/
public class DeFangIpAddress {

    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(deFangIpAddress(address));

    }

    private static String deFangIpAddress(String address) {
        return address.replace(".", "[.]");
    }


}

package cn.wllsrx.zoe.properties;

/**
 * @author zoe
 **/
public class JwtProperties {
    private static final JwtProperties jwtProperties = new JwtProperties();

    private JwtProperties() {
    }

    public static JwtProperties getJwtProperties() {
        return jwtProperties;
    }

    public static final String JWT_PREFIX = "jwt";

    /**
     * header
     */
    private String header = "Authorization";

    /**
     * 加密形式
     */
    private String secret = "defaultSecret";

    /**
     * 过期时间 默认七天
     */
    private Long expiration = 604800L;

    /**
     * 颁发jwt的路径
     */
    private String authPath = "login";

    /**
     * randomKey
     */
    private String md5Key = "randomKey";

    public static String getJwtPrefix() {
        return JWT_PREFIX;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public String getAuthPath() {
        return authPath;
    }

    public void setAuthPath(String authPath) {
        this.authPath = authPath;
    }

    public String getMd5Key() {
        return md5Key;
    }

    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key;
    }
}

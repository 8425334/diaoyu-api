package com.deb.diaoyu.demo.security.jwt;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.*;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Slf4j
@ToString
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWT {

    private String secret;
    private long expire;
    private String header;

    public String getToken(String identity){
        Date now = DateUtil.date();
        Date expire = new Date(now.getTime() + getExpire());

        return Jwts.builder()
                .setHeaderParam("typ", "jwt")
                .setSubject(encodeIdentity(identity))
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(SignatureAlgorithm.HS256, getSecret())
                .compact();
    }

    public String encodeIdentity(String identity){
        return Base64.encode(identity);
    }

    public String decodeIdentity(String identity){
        return Base64.decodeStr(identity);
    }

    public Claims getClaims(String token){
        return Jwts.parser()
                .setSigningKey(getSecret())
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isExpire(Date expireTime){
        return expireTime.before(DateUtil.date());
    }

}

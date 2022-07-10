package org.wyy.shirodemo;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;

public class CustomRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Map<String, String> dataFromDB = dataFromDB();
        if (dataFromDB.containsKey(username)) {
            return new SimpleAuthenticationInfo(username,dataFromDB.get(username),this.getName());

        } return null;
    }

    private Map<String,String> dataFromDB(){
        HashMap<String, String> map = new HashMap<>();
        map.put("wyy1","111");
        map.put("wyy2","222");
        map.put("wyy3","333");
        map.put("wyy4","444");
        map.put("wyy5","555");
        return map;
    }
}

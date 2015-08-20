package id.co.telkomsigma.hie.ldapcrud.controler;


import id.co.telkomsigma.hie.ldapcrud.model.User;

import java.security.MessageDigest;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.log4j.Logger;
 
/**
 *  com.edw.ldap.main.LDAPMain
 *
 *  @author edw
 */
public class LdapControler {
 
    private Logger logger = Logger.getLogger(LdapControler.class);
    private Hashtable<String, String> env = new Hashtable<String, String>();
 
    public LdapControler() {
        try {
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
            env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
            env.put(Context.SECURITY_CREDENTIALS, "xxx");
        } catch (Exception e) {
            logger.error(e, e);
        }
 
    }
 
    private boolean insert(User user) {
        try {
 
            DirContext dctx = new InitialDirContext(env);
            Attributes matchAttrs = new BasicAttributes(true);
            matchAttrs.put(new BasicAttribute("uid", user.getName()));
            matchAttrs.put(new BasicAttribute("cn", user.getName()));
            matchAttrs.put(new BasicAttribute("street", user.getAddress()));
            matchAttrs.put(new BasicAttribute("sn", user.getName()));
            matchAttrs.put(new BasicAttribute("userpassword", encryptLdapPassword("SHA", user.getPassword())));
            matchAttrs.put(new BasicAttribute("objectclass", "top"));
            matchAttrs.put(new BasicAttribute("objectclass", "person"));
            matchAttrs.put(new BasicAttribute("objectclass", "organizationalPerson"));
            matchAttrs.put(new BasicAttribute("objectclass", "inetorgperson"));
            String name = "uid=" + user.getName() + ",ou=users,ou=system";
            InitialDirContext iniDirContext = (InitialDirContext) dctx;
            iniDirContext.bind(name, dctx, matchAttrs);
 
            logger.debug("success inserting "+user.getName());
            return true;
        } catch (Exception e) {
            logger.error(e, e);
            return false;
        }
    }
 
    private boolean edit(User user) {
        try {
 
            DirContext ctx = new InitialDirContext(env);
            ModificationItem[] mods = new ModificationItem[2];
            Attribute mod0 = new BasicAttribute("street", user.getAddress());
            Attribute mod1 = new BasicAttribute("userpassword", encryptLdapPassword("SHA", user.getPassword()));
            mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
            mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod1);
 
            ctx.modifyAttributes("uid=" + user.getName() + ",ou=users,ou=system", mods);
 
            logger.debug("success editing "+user.getName());
            return true;
        } catch (Exception e) {
            logger.error(e, e);
            return false;
        }
    }
 
    private boolean delete(User user) {
        try {
 
            DirContext ctx = new InitialDirContext(env);
            ctx.destroySubcontext("uid=" + user.getName() + ",ou=users,ou=system");
 
            logger.debug("success deleting "+user.getName());
            return true;
        } catch (Exception e) {
            logger.error(e, e);
            return false;
        }
    }
     
    private boolean search(User user) {
        try {
 
            DirContext ctx = new InitialDirContext(env);
            String base = "ou=users,ou=system";
 
            SearchControls sc = new SearchControls();
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
 
            String filter = "(&(objectclass=person)(uid="+user.getName()+"))";
 
            NamingEnumeration results = ctx.search(base, filter, sc);
 
 
            while (results.hasMore()) {
                SearchResult sr = (SearchResult) results.next();
                Attributes attrs = sr.getAttributes();
 
                Attribute attr = attrs.get("uid");
                if(attr != null)
                    logger.debug("record found "+attr.get());
            }
            ctx.close();
                         
            return true;
        } catch (Exception e) {
            logger.error(e, e);
            return false;
        }
    }
 
    private String encryptLdapPassword(String algorithm, String _password) {
        String sEncrypted = _password;
        if ((_password != null) && (_password.length() > 0)) {
            boolean bMD5 = algorithm.equalsIgnoreCase("MD5");
            boolean bSHA = algorithm.equalsIgnoreCase("SHA")
                    || algorithm.equalsIgnoreCase("SHA1")
                    || algorithm.equalsIgnoreCase("SHA-1");
            if (bSHA || bMD5) {
                String sAlgorithm = "MD5";
                if (bSHA) {
                    sAlgorithm = "SHA";
                }
                try {
                    MessageDigest md = MessageDigest.getInstance(sAlgorithm);
                    md.update(_password.getBytes("UTF-8"));
                    sEncrypted = "{" + sAlgorithm + "}" + (new BASE64Encoder()).encode(md.digest());
                } catch (Exception e) {
                    sEncrypted = null;
                    logger.error(e, e);
                }
            }
        }
        return sEncrypted;
    }
 
    public static void main(String[] args) {
        LdapControler main = new LdapControler();
 
        User user = new User();
        user.setAddress("kebayoran");
        user.setName("kamplenk");
        user.setPassword("pepe");
 
        // insert
        main.insert(user);
         
        // edit
        main.edit(user);
         
        // select
        main.search(user);
         
        // delete
        main.delete(user);
    }
}

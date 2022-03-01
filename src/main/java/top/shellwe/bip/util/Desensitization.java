package top.shellwe.bip.util;


public class Desensitization {
        //匹配规则
        private static final String REGEX = "(^\\d{3})\\d.*(\\d{4}$)";
        //替换规则
        private static final String REPLACE = "$1****$2";

        /**
         * 手机号脱敏 153****8736
         * @param phone
         */
        public static String phoneMasking(String phone){
            if(!(phone).equals("")){
                return phone.replaceAll(REGEX, REPLACE);
            }
            return null;
        }

    /**
     * 身份证号脱敏 511********9768
     * @param id 身份证号
     */
    public static String idMasking(String id){
        if(!(id).equals("")){
            return id.replaceAll(REGEX, REPLACE);
        }
        return null;
    }

    public static String emailMasking(String email){
        if(!(email).equals("")){
            return email.replaceAll(REGEX, REPLACE);
        }
        return null;
    }

    public static String weChatMasking(String weChat){
        if(!(weChat).equals("")){
            return weChat.replaceAll(REGEX, REPLACE);
        }
        return null;
    }

    public static String nameMasking(String name){
        if(!(name).equals("")){
            return name.replaceAll(REGEX, REPLACE);
        }
        return null;
    }

    public static String cardMasking(String card){
        if(!(card).equals("")){
            return card.replaceAll(REGEX, REPLACE);
        }
        return null;
    }

}

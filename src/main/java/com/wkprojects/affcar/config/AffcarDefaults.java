package com.wkprojects.affcar.config;

public interface AffcarDefaults {
    public interface Security {
        public interface RememberMe {
            String key = null;
        }

        public interface Authentication {
            public interface Jwt {
                String secret = null;
                long tokenValidityInSeconds = 1800L;
                long tokenValidityInSecondsForRememberMe = 2592000L;
            }
        }

        public interface ClientAuthorization {
            String accessTokenUri = null;
            String tokenServiceId = null;
            String clientId = null;
            String clientSecret = null;
        }
    }

    public interface Mail {
        boolean enabled = false;
        String from = "";
        String baseUrl = "";
    }
}

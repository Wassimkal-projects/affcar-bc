package com.wkprojects.affcar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "affcar", ignoreUnknownFields = false)
public class AffcarProperties {

    private final CorsConfiguration cors = new CorsConfiguration();
    private final Security security = new Security();
    private final Mail mail = new Mail();

    public static class Mail {
        private boolean enabled = false;
        private String from = "";
        private String baseUrl = "";

        public Mail() {
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getFrom() {
            return this.from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getBaseUrl() {
            return this.baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }
    }

    public static class Security {
        private final Security.ClientAuthorization clientAuthorization = new Security.ClientAuthorization();
        private final Security.Authentication authentication = new Security.Authentication();
        private final Security.RememberMe rememberMe = new Security.RememberMe();

        public Security() {
        }

        public Security.ClientAuthorization getClientAuthorization() {
            return this.clientAuthorization;
        }

        public Security.Authentication getAuthentication() {
            return this.authentication;
        }

        public Security.RememberMe getRememberMe() {
            return this.rememberMe;
        }

        public static class RememberMe {
            @NotNull
            private String key;

            public RememberMe() {
                this.key = AffcarDefaults.Security.RememberMe.key;
            }

            public String getKey() {
                return this.key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }

        public static class Authentication {
            private final Security.Authentication.Jwt jwt = new Security.Authentication.Jwt();

            public Authentication() {
            }

            public Security.Authentication.Jwt getJwt() {
                return this.jwt;
            }

            public static class Jwt {
                private String secret;
                private long tokenValidityInSeconds;
                private long tokenValidityInSecondsForRememberMe;

                public Jwt() {
                    this.secret = AffcarDefaults.Security.Authentication.Jwt.secret;
                    this.tokenValidityInSeconds = 1800L;
                    this.tokenValidityInSecondsForRememberMe = 2592000L;
                }

                public String getSecret() {
                    return this.secret;
                }

                public void setSecret(String secret) {
                    this.secret = secret;
                }

                public long getTokenValidityInSeconds() {
                    return this.tokenValidityInSeconds;
                }

                public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                    this.tokenValidityInSeconds = tokenValidityInSeconds;
                }

                public long getTokenValidityInSecondsForRememberMe() {
                    return this.tokenValidityInSecondsForRememberMe;
                }

                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                    this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                }
            }
        }

        public static class ClientAuthorization {
            private String accessTokenUri;
            private String tokenServiceId;
            private String clientId;
            private String clientSecret;

            public ClientAuthorization() {
                this.accessTokenUri = AffcarDefaults.Security.ClientAuthorization.accessTokenUri;
                this.tokenServiceId = AffcarDefaults.Security.ClientAuthorization.tokenServiceId;
                this.clientId = AffcarDefaults.Security.ClientAuthorization.clientId;
                this.clientSecret = AffcarDefaults.Security.ClientAuthorization.clientSecret;
            }

            public String getAccessTokenUri() {
                return this.accessTokenUri;
            }

            public void setAccessTokenUri(String accessTokenUri) {
                this.accessTokenUri = accessTokenUri;
            }

            public String getTokenServiceId() {
                return this.tokenServiceId;
            }

            public void setTokenServiceId(String tokenServiceId) {
                this.tokenServiceId = tokenServiceId;
            }

            public String getClientId() {
                return this.clientId;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public String getClientSecret() {
                return this.clientSecret;
            }

            public void setClientSecret(String clientSecret) {
                this.clientSecret = clientSecret;
            }
        }
    }
}

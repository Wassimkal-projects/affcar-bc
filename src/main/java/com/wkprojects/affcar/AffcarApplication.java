package com.wkprojects.affcar;

import com.wkprojects.affcar.config.AffcarProperties;
import com.wkprojects.affcar.config.DefaultProfileUtil;
import com.wkprojects.affcar.config.Profiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
@EnableConfigurationProperties({AffcarProperties.class})
public class AffcarApplication {
    private static final Logger logger = LogManager.getLogger(AffcarApplication.class);

    private final Environment env;

    public AffcarApplication(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) {
        SpringApplication affcarApp = new SpringApplication(AffcarApplication.class);
        DefaultProfileUtil.addDefaultProfile(affcarApp);
        Environment env = affcarApp.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            logger.warn("The host name could not be determined, using `localhost` as fallback");
        }
        logger.info("\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}://localhost:{}\n\t"
                        + "External: \t{}://{}:{}\n\t" + "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"), protocol, env.getProperty("server.port"), protocol, hostAddress,
                env.getProperty("server.port"), env.getActiveProfiles());
    }

    @PostConstruct
    public void initApplication() {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(Profiles.SPRING_PROFILE_DEVELOPMENT)
                && activeProfiles.contains(Profiles.SPRING_PROFILE_PRODUCTION)) {
            logger.error("You have misconfigured your application! It should not run "
                    + "with both the 'dev' and 'prod' profiles at the same time.");
        }
    }

}

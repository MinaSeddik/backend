package db.migration.support;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class SeedUserMigrationSupport extends BaseJavaMigration {

    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    protected abstract String defaultUsername();

    protected abstract String usernameEnvVar();

    protected abstract String passwordEnvVar();

    protected abstract String defaultPassword();

    @Override
    public void migrate(Context context) throws Exception {
        String username = envOrDefault(usernameEnvVar(), defaultUsername());
        String password = envOrDefault(passwordEnvVar(), defaultPassword());

        if (userExists(context, username)) {
            return;
        }

        try (PreparedStatement statement = context.getConnection().prepareStatement(
                "INSERT INTO app_users (username, password) VALUES (?, ?)"
        )) {
            statement.setString(1, username);
            statement.setString(2, PASSWORD_ENCODER.encode(password));
            statement.executeUpdate();
        }
    }

    private boolean userExists(Context context, String username) throws SQLException {
        try (PreparedStatement statement = context.getConnection().prepareStatement(
                "SELECT COUNT(*) FROM app_users WHERE username = ?"
        )) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                return resultSet.getInt(1) > 0;
            }
        }
    }

    private String envOrDefault(String key, String defaultValue) {
        String value = System.getenv(key);
        return value == null || value.isBlank() ? defaultValue : value;
    }
}

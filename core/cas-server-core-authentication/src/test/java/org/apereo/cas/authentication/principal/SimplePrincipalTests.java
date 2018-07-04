package org.apereo.cas.authentication.principal;

import lombok.val;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author Misagh Moayyed
 * @since 4.1
 */
@Slf4j
public class SimplePrincipalTests {

    private static final File JSON_FILE = new File(FileUtils.getTempDirectoryPath(), "simplePrincipal.json");

    private static final ObjectMapper MAPPER = new ObjectMapper().findAndRegisterModules();

    @Test
    public void verifySerializeACompletePrincipalToJson() throws IOException {
        final HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("attribute", "value");
        val principalWritten = new SimplePrincipal("id", attributes);

        MAPPER.writeValue(JSON_FILE, principalWritten);

        val principalRead = MAPPER.readValue(JSON_FILE, SimplePrincipal.class);

        assertEquals(principalWritten, principalRead);
    }

    @Test
    public void verifySerializeAPrincipalWithEmptyAttributesToJson() throws IOException {
        val principalWritten = new SimplePrincipal("id", new HashMap<>(0));
        MAPPER.writeValue(JSON_FILE, principalWritten);
        val principalRead = MAPPER.readValue(JSON_FILE, SimplePrincipal.class);
        assertEquals(principalWritten, principalRead);
    }

}

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class JavaUUIDTest {

    private static Long MSB = 0xe3905e79d8fb4a11L; // 7544302429964684081
    private static Long LSB = 0xa33369988e1b1d6aL; // -5380732791977519936
    private static String STR = "e3905e79-d8fb-4a11-a333-69988e1b1d6a";

    private static boolean VERBOSE = false;

    @Test
    void unsignedLongs() {
        Long m = Long.parseUnsignedLong(Long.toHexString(MSB), 16);
        val s = String.format("%x", m);
        assertThat(s, equalTo("e3905e79d8fb4a11"));
    }

    //    @Test
    //    void uidStringFromLongs() {
    //        try {
    //            val uuid = JavaUUID.createUUID(Long.toHexString(MSB), Long.toHexString(LSB), 16);
    //            assertThat(uuid.toString(), equalTo(STR));
    //            assertThat(JavaUUID.getMostSignificantBits(uuid), equalTo(MSB));
    //            assertThat(JavaUUID.getLeastSignificantBits(uuid), equalTo(LSB));
    //            verifyUUID(uuid);
    //        } catch (NumberFormatException e) {
    //            e.printStackTrace();
    //            throw e;
    //        }
    //    }

    @Test
    void uidFromStrings() {
        val uuid = fixedUUID();
        assertThat(uuid.toString(), equalTo(STR));
        assertThat(JavaUUID.getMostSignificantBits(uuid), equalTo(MSB));
        assertThat(JavaUUID.getLeastSignificantBits(uuid), equalTo(LSB));
        verifyUUID(uuid);
    }

    @Test
    void uidFromString() {
        val uuid = JavaUUID.fromString(STR);
        assertThat(uuid.toString(), equalTo(STR));
        assertThat(JavaUUID.getMostSignificantBits(uuid), equalTo(MSB));
        assertThat(JavaUUID.getLeastSignificantBits(uuid), equalTo(LSB));
        verifyUUID(uuid);
    }

    @Test
    void randomUID() {
        val uuid = newRandomUUID();
        verifyUUID(uuid);
    }

    private void verifyUUID(UUID uuid) {
        assertThat(uuid.toString(), matchesPattern("[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}"));
        assertThat(uuid, equalTo(JavaUUID.createUUID(JavaUUID.getMostSignificantBits(uuid),JavaUUID.getLeastSignificantBits(uuid))));
    }

    private UUID fixedUUID() {
        val value = JavaUUID.createUUID(MSB, LSB);
        dumpUUID(value);
        return JavaUUID.createUUID(MSB, LSB);
    }

    private void dumpUUID(UUID value) {
        if(VERBOSE) {
            System.out.println(String.format("MSB %x = %d", value.getMostSignificantBits(), value.getMostSignificantBits()));
            System.out.println(String.format("LSB %x = %d", value.getLeastSignificantBits(), value.getLeastSignificantBits()));
            System.out.println(String.format("Str %s", value.toString()));
            System.out.println(String.format("var   %s", value.variant()));
            System.out.println(String.format("ver   %s", value.version()));
            switch (value.version()) {
                case 1:
                    System.out.println(String.format("clock %s", value.clockSequence()));
                    System.out.println(String.format("time  %s", value.timestamp()));
                    System.out.println(String.format("node  %s", value.node()));
            }
        }
    }
    private UUID newRandomUUID() {
        val value = JavaUUID.randomUUID();
        dumpUUID(value);
        return value;

    }
}


//import lombok.experimental.Delegate;

import java.util.Objects;
import java.util.UUID;

/**
 * java.util.UUID warpper
 *
 * This library calls methods from java.util.UUID.
 */
public class JavaUUID {

    //    @Delegate(types=java.util.UUID.class)
    //    private transient UUID uuid;
    //
    //    public JavaUUID() {
    //        new UUID(0, 0);
    //    }
    //
    //    public (long mostSigBits, long leastSigBits) {
    //        uuid = new UUID(mostSigBits, leastSigBits);
    //    }


    /**
     * The clock sequence value associated with this UUID.
     *
     * <p> The 14 bit clock sequence value is constructed from the clock
     * sequence field of this UUID.  The clock sequence field is used to
     * guarantee temporal uniqueness in a time-based UUID.
     *
     * <p> The {@code clockSequence} value is only meaningful in a time-based
     * UUID, which has version type 1.  If this UUID is not a time-based UUID
     * then this method throws UnsupportedOperationException.
     * @param  val {@code UUID}
     * @return  The clock sequence of this {@code UUID}
     * @throws  UnsupportedOperationException
     *          If this UUID is not a version 1 UUID
     */
    public static int clockSequence(UUID val) {
        return val.clockSequence();
    }

    /**
     * Compares two UUIDs.
     *
     * <p> The first of two UUIDs is greater than the second if the most
     * significant field in which the UUIDs differ is greater for the first
     * UUID.
     * @param  val1 first {@code UUID} to be compared
     * @param  val2 second {@code UUID} to be compared
     * @return  -1, 0 or 1 as this {@code UUID} is less than, equal to, or
     *          greater than {@code val}
     *
     */
    public static int compareTo(UUID val1, UUID val2) {
        return val1.compareTo(val2);
    }

    /**
         * Constructs a new {@code UUID} using the specified data.  {@code
         * mostSigBits} is used for the most significant 64 bits of the {@code
         * UUID} and {@code leastSigBits} becomes the least significant 64 bits of
         * the {@code UUID}.
         * @param  mostSigBits The most significant bits of the {@code UUID}
         * @param  leastSigBits The least significant bits of the {@code UUID}
         * @return  A {@code UUID} generated from the specified parameters
         */
    public static UUID createUUID(Long mostSigBits, Long leastSigBits) {
        return new UUID(mostSigBits, leastSigBits);
    }
    //    public static UUID createUUID(String mostSigBits, String leastSigBits) {
    //        return createUUID(mostSigBits, leastSigBits, 10);
    //    }
    //    public static UUID createUUID(String mostSigBits, String leastSigBits, int radix) {
    //        switch (radix) {
    //            default:
    //                throw new IllegalArgumentException("bad radix, supported values are 10 and 16");
    //            case 10:
    //                return createUUID(Long.parseLong(mostSigBits,radix), Long.parseLong(leastSigBits, radix));
    //            case 16:
    //                return createUUID(Long.parseUnsignedLong(mostSigBits,radix), Long.parseUnsignedLong(leastSigBits, radix)); // requires java 8 (1.8)
    //        }
    //    }

    /**
     * Returns {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     * Consequently, if both arguments are {@code null}, {@code true}
     * is returned and if exactly one argument is {@code null}, {@code
     * false} is returned.  Otherwise, equality is determined by using
     * the {@link Object#equals equals} method of the first
     * argument.
     * @param a an object
     * @param b an object to be compared with {@code a} for equality
     * @return {@code true} if the arguments are equal to each other
     * and {@code false} otherwise
     * @see Object#equals(Object)
     */
    public static boolean equals(Object a, Object b) {
        return Objects.equals(a, b);
    }

    /**
     * Creates a {@code UUID} from the string standard representation as
     * described in the {@link #toString} method.
     *
     * @param  name
     *         A string that specifies a {@code UUID}
     *
     * @return  A {@code UUID} with the specified value
     *
     * @throws  IllegalArgumentException
     *          If name does not conform to the string representation as
     *          described in {@link #toString}
     *
     */
    public static UUID fromString(String name) {
        return UUID.fromString(name);
    }

    /**
     * Returns the least significant 64 bits of this UUID's 128 bit value.
     * @param  val {@code UUID}
     * @return  The least significant 64 bits of this UUID's 128 bit value
     */
    public static Long getLeastSignificantBits(UUID val) {
        return val.getLeastSignificantBits();
    }

    /**
     * Returns the most significant 64 bits of this UUID's 128 bit value.
     * @param  val {@code UUID}
     * @return  The most significant 64 bits of this UUID's 128 bit value
     */
    public static Long getMostSignificantBits(UUID val) {
        return val.getMostSignificantBits();
    }


    /**
     * Static factory to retrieve a type 3 (name based) {@code UUID} based on
     * the specified byte array.
     * @param  name A byte array to be used to construct a {@code UUID}
     * @return  A {@code UUID} generated from the specified array
     */
    public static UUID nameUUIDFromBytes(byte[] name) {
        return UUID.nameUUIDFromBytes(name);
    }

    /**
     * The node value associated with this UUID.
     * <p> The 48 bit node value is constructed from the node field of this
     * UUID.  This field is intended to hold the IEEE 802 address of the machine
     * that generated this UUID to guarantee spatial uniqueness.
     * <p> The node value is only meaningful in a time-based UUID, which has
     * version type 1.  If this UUID is not a time-based UUID then this method
     * throws UnsupportedOperationException.
     * @return  The node value of this {@code UUID}
     * @param  val {@code UUID}
     * @throws  UnsupportedOperationException
     *          If this UUID is not a version 1 UUID
     */
    public static long node(UUID val) {
        return val.node();
    }


        /**
             * Static factory to retrieve a type 4 (pseudo randomly generated) UUID.
             * The {@code UUID} is generated using a cryptographically strong pseudo
             * random number generator.
             * @return  A randomly generated {@code UUID}
             */
    public static UUID randomUUID() {
        return UUID.randomUUID();
    }

//    /**
//     * Static factory to retrieve a type 4 (pseudo randomly generated) UUID.
//     * The {@code UUID} is generated using a cryptographically strong pseudo
//     * random number generator.
//     * @return  A randomly generated {@code String}
//     */
//    public static String randomUUIDString() {
//        return randomUUID().toString();
//    }

    /**
     * The timestamp value associated with this UUID.
     *
     * <p> The 60 bit timestamp value is constructed from the time_low,
     * time_mid, and time_hi fields of this {@code UUID}.  The resulting
     * timestamp is measured in 100-nanosecond units since midnight,
     * October 15, 1582 UTC.
     * <p> The timestamp value is only meaningful in a time-based UUID, which
     * has version type 1.  If this {@code UUID} is not a time-based UUID then
     * this method throws UnsupportedOperationException.
     * @param  val {@code UUID}
     * @throws UnsupportedOperationException
     *         If this UUID is not a version 1 UUID
     * @return The timestamp of this {@code UUID}.
     */
    public static long timestamp(UUID val) {
        return val.timestamp();
    }

//    /**
//     * Returns a String object representing this UUID.
//     *
//     * Examples:
//     * | To String | val |
//     */
//    public static String toStringRobotDoc(UUID val) {
//        return val.toString();
//    }

    /**
     * Returns a {@code String} object representing this {@code UUID}.

     * <p> The UUID string representation is as described by this BNF:
     * <blockquote><pre>
     * {@code
     * UUID                   = <time_low> "-" <time_mid> "-"
     *                          <time_high_and_version> "-"
     *                          <variant_and_sequence> "-"
     *                          <node>
     * time_low               = 4*<hexOctet>
     * time_mid               = 2*<hexOctet>
     * time_high_and_version  = 2*<hexOctet>
     * variant_and_sequence   = 2*<hexOctet>
     * node                   = 6*<hexOctet>
     * hexOctet               = <hexDigit><hexDigit>
     * hexDigit               =
     *       "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
     *       | "a" | "b" | "c" | "d" | "e" | "f"
     *       | "A" | "B" | "C" | "D" | "E" | "F"
     * }</pre></blockquote>
     * @param  val {@code UUID}
     * @return  A string representation of this {@code UUID}
     *
     * Examples:
     * | To String | val |
     */
    public String toString(UUID val) {
        return val.toString();
    }

    /**
     * The variant number associated with this {@code UUID}.  The variant
     * number describes the layout of the {@code UUID}.
     *
     * The variant number has the following meaning:
     * <ul>
     * <li>0    Reserved for NCS backward compatibility
     * <li>2    <a href="http://www.ietf.org/rfc/rfc4122.txt">IETF&nbsp;RFC&nbsp;4122</a>
     * (Leach-Salz), used by this class
     * <li>6    Reserved, Microsoft Corporation backward compatibility
     * <li>7    Reserved for future definition
     * </ul>
     * @param  val {@code UUID}
     * @return  The variant number of this {@code UUID}
     */
    public static int variant(UUID val) {
        return val.variant();
    }

    /**
     * The version number associated with this {@code UUID}.  The version
     * number describes how this {@code UUID} was generated.
     *
     * The version number has the following meaning:
     * <ul>
     * <li>1    Time-based UUID
     * <li>2    DCE security UUID
     * <li>3    Name-based UUID
     * <li>4    Randomly generated UUID
     * </ul>
     * @param  val {@code UUID}
     * @return  The version number of this {@code UUID}
     */
    public static int version(UUID val) {
        return val.version();
    }
}

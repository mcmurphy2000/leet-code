import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    @Test
    public void shouldWork() {
        final AuthenticationManager manager = new AuthenticationManager(5);
        manager.renew("aaa", 1);
        manager.generate("aaa", 2);

        assertEquals(1, manager.countUnexpiredTokens(6));

        manager.generate("bbb", 7);
        manager.renew("aaa", 8);
        manager.renew("bbb", 10);

        assertEquals(0, manager.countUnexpiredTokens(15));
    }
}

package ru.skubatko.dev.hackerrank.case003;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class Case003Test {

    @Rule
    public Timeout timeout = Timeout.seconds(5);

    @Test
    public void isBalancedCase1() {
        String s = "{[()]}";

        String result = Case003.isBalanced(s);

        assertThat(result).isEqualTo("YES");
    }

    @Test
    public void isBalancedCase2() {
        String s = "{[(])}";

        String result = Case003.isBalanced(s);

        assertThat(result).isEqualTo("NO");
    }

    @Test
    public void isBalancedCase3() {
        String s = "{{[[(())]]}}";

        String result = Case003.isBalanced(s);

        assertThat(result).isEqualTo("YES");
    }

    @Test
    public void isBalancedCase4() {
        String s = "{{([])}}";

        String result = Case003.isBalanced(s);

        assertThat(result).isEqualTo("YES");
    }

    @Test
    public void isBalancedCase5() {
        String s = "{{)[](}}";

        String result = Case003.isBalanced(s);

        assertThat(result).isEqualTo("NO");
    }

    @Test
    public void isBalancedCase6() {
        String s = "{(([])[])[]}";

        String result = Case003.isBalanced(s);

        assertThat(result).isEqualTo("YES");
    }

    @Test
    public void isBalancedCase7() {
        String s = "{(([])[])[]]}";

        String result = Case003.isBalanced(s);

        assertThat(result).isEqualTo("NO");
    }

    @Test
    public void isBalancedCase8() {
        String s = "{(([])[])[]}[]";

        String result = Case003.isBalanced(s);

        assertThat(result).isEqualTo("YES");
    }
}

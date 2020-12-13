import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class PraseJwtTest {

    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJjb21wYW55SWQiOiIxIiwiY29tcGFueU5hbWUiOiLkvKDmmbrmkq3lrqIiLCJleHAiOjE2MDc3NjU1MTh9.cIF4QXjShLivPERZjZnVLlMfKF-Tu_xTAA33jnE-Pwg";
        Claims claims = Jwts.parser().setSigningKey("saas-ihrm").parseClaimsJws(token).getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());


    }
}

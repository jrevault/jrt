package com.navadra;

import static io.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;

import jrt.App;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.jooby.test.JoobyRule;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author jooby generator
 */
public class AppTest {

  /**
   * One app/server for all the test of this class. If you want to start/stop a new server per test,
   * remove the static modifier and replace the {@link ClassRule} annotation with {@link Rule}.
   */
  @ClassRule
  public static JoobyRule app = new JoobyRule(new App());

  @Test
  public void integrationTest() {
    Response res = get( "/v1/tests/ping").thenReturn();
    ResponseBody body = res.peek();
    assertEquals( 200, res.statusCode() );
    assertEquals( "\"pong\"", body.print());

  }


}

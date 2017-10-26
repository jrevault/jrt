package jrt;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.typesafe.config.Config;
import jrt.algos.AlgoService;
import org.jooby.*;
import org.jooby.mvc.GET;
import org.jooby.mvc.Path;

import java.util.List;

@Path ( "/tests" )
public class TestsController {

  private Request  req;

  @Inject
  public TestsController( Request req ) {
    this.req = req;
  }

  @GET
  @Path ( "/:algo_code" )
  public Result test() {
    try {
      // In real app, algo_code is coming from DB depending on user
      String algo_code = req.param( "algo_code" ).value();

      String algo_classname = "jrt.algos.AlgoService_" + algo_code;
      AlgoService algo_class = ( AlgoService ) Class.forName( algo_classname ).newInstance();
      Injector injector = App.instance.require(Injector.class);
      injector.injectMembers(algo_class);
      List<String> list = algo_class.generate();

      return Results.ok( list );
    }
    catch ( Exception ex ) {
      ex.printStackTrace();
      return Results.with( ex , 500 );
    }
  }


}

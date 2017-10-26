package jrt;

import org.jooby.Jooby;
import org.jooby.json.Jackson;
import org.jooby.scanner.Scanner;

public class App extends Jooby {

  public static void main( final String[] args ) {
    run( App::new , args );
  }

  {
    use( new Jackson());

    use( new Scanner(
        "jrt" ,
        "jrt.algos"
    ) );

  }

}

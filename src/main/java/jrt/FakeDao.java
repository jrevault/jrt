package jrt;

import java.util.ArrayList;
import java.util.List;

public class FakeDao {

  /**
   * Just a dumb dao that returns a list
   * @param size number of element of the returned list
   * @return a dumb list
   */
  public List<String> get_list( int size) {
    // Real life means getting algo class
    List<String> res = new ArrayList<>( size );
    for ( int i = 0 ; i < size ; i++ ) {
      res.add( "Exercise " + i );
    }
    return res;
  }

}
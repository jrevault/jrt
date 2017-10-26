package jrt.algos;

import com.google.inject.Inject;
import jrt.FakeDao;

import java.util.List;

public class AlgoService_002 extends AlgoService {

  // Fake dao to see if injection works via reflection
  @Inject
  protected FakeDao fake_dao;

  /**
   * Damn I's such useless without the real code :)
   *
   * @return a dumb list
   */
  @Override
  public List<String> generate() {
    return fake_dao.get_list( 3 );
  }
}

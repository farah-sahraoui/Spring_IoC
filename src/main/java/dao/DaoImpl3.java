package dao;

import org.springframework.stereotype.Component;

@Component("dao3")
public class DaoImpl3 implements IDao {
    @Override
    public double getValue() {

        return 250.0;
    }
}

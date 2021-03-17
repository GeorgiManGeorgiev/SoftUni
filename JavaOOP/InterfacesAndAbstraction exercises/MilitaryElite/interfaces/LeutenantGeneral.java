package P06.interfaces;

import P06.PrivateImpl;

import java.util.List;

public interface LeutenantGeneral {

    void addPrivate(PrivateImpl priv);

    List<PrivateImpl> getPrivates();
}
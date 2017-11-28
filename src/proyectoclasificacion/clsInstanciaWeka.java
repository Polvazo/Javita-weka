package proyectoclasificacion;

import java.io.IOException;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

public class clsInstanciaWeka {
     public Instance crearInstancia(Float cemento,Float escoriaaltohorno,Float cenizavolante,
             Float agua,Float Superplastificante,Float hormigon,
             Float arena,Float tiempo,Instances train) throws IOException{
        /* El número 2, es el número de atributos que aparecen en el corpus (clima y temperatura). */
        Instance instance = new Instance(9);
        
        /* Se escribe sólo los atributos sin considerar las clases, en este caso, solo queda temperatura */
        Attribute atributo1 = train.attribute("cemento");
        Attribute atributo2 = train.attribute("escoriaaltohorno");
        Attribute atributo3 = train.attribute("cenizavolante");
        Attribute atributo4= train.attribute("agua");
        Attribute atributo5= train.attribute("Superplastificante");
        Attribute atributo6= train.attribute("hormigon");
        Attribute atributo7= train.attribute("arena");
        Attribute atributo8= train.attribute("tiempo");
      
        
        instance.setValue(atributo1, cemento);
        instance.setValue(atributo2, escoriaaltohorno);
        instance.setValue(atributo3, cenizavolante);
        instance.setValue(atributo4, agua);
        instance.setValue(atributo5, Superplastificante);
        instance.setValue(atributo6, hormigon);
        instance.setValue(atributo7, arena);
        instance.setValue(atributo8, tiempo);
        instance.setDataset(train);
        
        return instance;
    }
}

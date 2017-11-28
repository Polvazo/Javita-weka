package proyectoclasificacion;

import weka.classifiers.Classifier;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class clsClasificacion {
    private static Instances train;
    Classifier Classifier;
    Instances data;
    
    public clsClasificacion(String corpus, String modelo) throws Exception{
        
        Classifier = (LinearRegression) weka.core.SerializationHelper.read(modelo);
        train = ConverterUtils.DataSource.read(corpus);
        train.setClassIndex(0);  
        data = new Instances(train);
    }
    
    public String clasificar(Float cemento,Float escoriaaltohorno,Float cenizavolante,
             Float agua,Float Superplastificante,Float hormigon,
             Float arena,Float tiempo) throws Exception{
        double predicted;
        System.out.println("paso por aqui"+arena);
        Instance instance;
        clsInstanciaWeka instancia = new clsInstanciaWeka();

        if(train.numInstances()==0){
            throw new Exception("No classifier available");
        }

        instance = instancia.crearInstancia(cemento, escoriaaltohorno, cenizavolante,
             agua, Superplastificante, hormigon, arena, tiempo, data);
        Classifier.buildClassifier(data);
        predicted = Classifier.classifyInstance(instance);
        System.out.println("paso por aqui"+train.classAttribute().value((int)predicted));
        return String.valueOf(predicted);
    }
}



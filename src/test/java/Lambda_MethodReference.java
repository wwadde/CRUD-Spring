import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lambda_MethodReference {

    List<String> nombres = Arrays.asList("William", "Orlando", "Daniel", "Brayan", "Juan");
    List<String> nombresMayusculas = nombres.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> numerosPares = numeros.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());


    List<Integer> numeros2 = Arrays.asList(1, 2, 3, 4, 5);
    int suma = numeros2.stream()
            .reduce(0, Integer::sum);


    List<Integer> numeros3 = Arrays.asList(1, 2, 3, 4, 5);
    Optional<Integer> minimo = numeros.stream()
            .min(Integer::compareTo);

    public static void main(String[] args) {
        Lambda_MethodReference lambda = new Lambda_MethodReference();
        lambda.nombresMayusculas.forEach(System.out::println);
        //TODO mirar si puedo iterar sobre la lista directamente
    }

}

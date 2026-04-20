¿Cuánto tiempo tardaste en entender el código original antes de poder modificarlo?
R/ Aproximadamente 3 hora y media, no entendia las relaciones y aveces lo que significaban las variables como x, o aux, etc
.

¿Qué parte fue más difícil de descifrar?
R/ En utilidades no entendia los if, los nombres de las variables no me permitían entender, me toco leer varias veces el codigo para poder entender


¿Cuál de las 34 malas prácticas te pareció la más peligrosa en un sistema real? ¿Por qué?
R/El 17 ya que en el método validar solo debería validar, pero modifica el valor de unas variables, lo cual esta bien, pero que tal que esten mal, cuando se este buscando el error, posiblemente no lo busquen ahí, ya que según su nombre solo se valida, no se modifica nada
 
¿Qué pasaría si este sistema tuviera 50.000 líneas en lugar de ~200? ¿Cuánto costaría agregar un nuevo impuesto del 2%?

R/ Tardaria demasiado, ya que la el impuesto ese está en muchas clases, y no es una variable global, la idea es que se cree solo una vez y se mande a llamar cuando se necesite, asi solo se cambia en la clase datos


Identifica al menos un punto donde podrías haber introducido un bug accidentalmente al refactorizar. ¿Cómo lo detectarías?

R/ seria donde están la variables de una sola letra, (a, b, c, etc) podría confundir a que se refieren y dañar el codigo, y lo detectaría cuando lo corra y no de los valores correctos, y me tocaria buscar codigo por codigo para saber donde está mal

El método validar() tiene un efecto secundario oculto: además de validar, modifica Datos.tot y Datos.tmp. ¿Por qué este tipo de bugs son especialmente difíciles de encontrar en producción?

R/ porque según el nombre no se debería modificar nada, solo leer y validar, y cuando se esté buscando el error se buscaría en calcular, mas no en validar

¿Cómo conectas este ejercicio con los casos reales de Knight Capital ($440M en 45 minutos), Southwest Airlines (17.000 vuelos cancelados) o Equifax (147M de registros filtrados) vistos en clase?

R/ en knight capital había codigo viejo sin eliminar, similar a una parte del codigo sucio donde había codigo antiguo pero estaba en comentarios, que tal que al momento de refactorizar y ordenar, lo hubiera dejado sin comentarios, hubiera sido un caos total, el de southwest es similar, ya que era difícil mejorarlo ya que el sistema era muy viejo y largo, aquí es mas corto pero igual era dificl de entender, nosotros tuvimos la fortuna de que teníamos mas tiempo y no eran tantas líneas, pero el de ellos debia ser lo antes posible y debió ser muchas líneas, y en Equifax no se podía cambiar nada porque seguramente algo se dañaba, similar a los valores del iva, que para modificar un solo valor era muy difícil porque la variable estaba en casi todas las clases.

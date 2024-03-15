[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/NBVXLiSy)
# Actividad: Desarrollo de Proyecto Software en Kotlin

**ID actividad:** 2324_PRO_u4u5u6_libre

**Agrupamiento de la actividad**: Individual 

---

### Descripción:

La actividad consiste en el desarrollo de un proyecto software en Kotlin, permitiendo al estudiante elegir la temática. Este proyecto debe demostrar la comprensión y aplicación de los conceptos de programación orientada a objetos (POO), incluyendo la definición y uso de clases, herencia, interfaces, genericos, principios SOLID y el uso de librerías externas.

**Objetivo:**

- Demostrar comprensión de los fundamentos de POO mediante la instanciación y uso de objetos.
- Aplicar conceptos avanzados de POO como herencia, clases abstractas, e interfaces.
- Crear y usar clases que hagan uso de genéricos. 
- Aplicar principios SOLID.
- Integrar y utilizar librerías de clases externas para extender la funcionalidad del proyecto.
- Documentar y presentar el código de manera clara y comprensible.

**Trabajo a realizar:**

1. **Selección de la Temática:** Elige un tema de tu interés que pueda ser abordado mediante una aplicación software. Esto podría ser desde una aplicación de gestión para una pequeña empresa, una herramienta para ayudar en la educación, hasta un juego simple. Define claramente el problema que tu aplicación pretende resolver.

2. **Planificación:** Documenta brevemente cómo tu aplicación solucionará el problema seleccionado, incluyendo las funcionalidades principales que desarrollarás.

3. **Desarrollo:**
   - **Instancia de Objetos:** Tu aplicación debe crear y utilizar objetos, demostrando tu comprensión de la instanciación y el uso de constructores, métodos, y propiedades.
   - **Métodos Estáticos:** Define y utiliza al menos un método estático, explicando por qué es necesario en tu aplicación.
   - **Uso de IDE:** Desarrolla tu proyecto utilizando un IDE, aprovechando sus herramientas para escribir, compilar, y probar tu código.
   - **Definición de Clases:** Crea clases personalizadas con sus respectivas propiedades, métodos, y constructores.
   - **Clases con genéricos:** Define y utiliza al menos una clase que haga uso de genéricos en tu aplicación.
   - **Herencia y Polimorfismo:** Implementa herencia y/o interfaces en tu proyecto para demostrar la reutilización de código y la flexibilidad de tu diseño.  **Usa los principios SOLID:** Ten presente durante el desarrollo los principios SOLID y úsalos durante el diseño para mejorar tu aplicación.
   - **Librerías de Clases:** Integra y utiliza una o más librerías externas que enriquezcan la funcionalidad de tu aplicación.
   - **Documentación:** Comenta tu código de manera efectiva, facilitando su comprensión y mantenimiento.

4. **Prueba y Depuración:** Realiza pruebas para asegurarte de que tu aplicación funciona como se espera y depura cualquier error encontrado.
5. **Contesta a las preguntas** ver el punto **Preguntas para la Evaluación**

### Recursos

- Apuntes dados en clase sobre programación orientada a objetos, Kotlin, uso de IDEs, y manejo de librerías.
- Recursos vistos en clase, incluyendo ejemplos de código, documentación de Kotlin, y guías de uso de librerías.

### Evaluación y calificación

**RA y CE evaluados**: Resultados de Aprendizaje 2, 4, 6, 7 y Criterios de Evaluación asociados.

**Conlleva presentación**: SI

**Rubrica**: Mas adelante se mostrará la rubrica.

### Entrega

> **La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada.**
>
- **Conlleva la entrega de URL a repositorio:** El contenido se entregará en un repositorio GitHub. 
- **Respuestas a las preguntas:** Deben contestarse en este fichero, README.md


# Preguntas para la Evaluación

Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, **asegúrate de hacer referencia y enlazar al código relevante** en tu `README.md`, facilitando así la evaluación de tu trabajo.

#### **Criterio global 1: Instancia objetos y hacer uso de ellos**
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.f, 4.a)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/f5d4645af0dc55e1dc3d0e2e09817871c9b31522/src/main/kotlin/Main.kt#L19-L25
He instanciado dos objetos de las clases GestionClientes y Polizas en el main para utilizar los mettodos que guardan los datos que ay en los archivos de clientes y polizas en una lista que usaré a lo largo del programa para facilitar las búsquedas y demás sobre las listas.

También para llamar a las funciones de consola, he instanciado en las funciones que las utiliza un objeto de cosola.
https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/f5d4645af0dc55e1dc3d0e2e09817871c9b31522/src/main/kotlin/Polizas/Poliza.kt#L20

#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.i)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?

 Si. En las clases Poliza y GestionClientes.
 https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/f5d4645af0dc55e1dc3d0e2e09817871c9b31522/src/main/kotlin/Polizas/Poliza.kt#L9-L19
 https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/fa278d5715064a75dd0c0eb6942cb16cf3b83366/src/main/kotlin/Clientes/GestionClientes.kt#L13-L24
 El objetivo de esto era asegurar  que solo existiera una instancia compartida de la lista de base de datos (polizas) en lugar de que cada instancia de Poliza y GestionClientes tuviera su propia lista.
  
- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?

  https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/fa278d5715064a75dd0c0eb6942cb16cf3b83366/src/main/kotlin/Polizas/Poliza.kt#L105-L129
  En la función guardarPoliza de la clase Poliza, se utiliza la propiedad estática polizas que se encuentra dentro del companion object. Esta propiedad se utiliza para agregar la póliza recién creada a la lista de pólizas existente en la clase Poliza y añadirla al archivo de polizas.

#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.

  El IDE ha sido de gran ayuda en cuanto simplificación de código y corrección de errores de sintaxis. El modo de depuración ha sido una herramienta fundamental para ejecutar mi programa paso a paso, detectar y corregir errores.

#### **Criterio global 4: Definir clases y su contenido**
- **(4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?

  En este proyecto se definen diferentes tipos de clases,como data class, enum class y abstract class
  
   - Data class Cliente: usada para guardar los datos de un cliente de forma ordenada.
   https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/4382b432616d06b1b0029131b70ab1c492823b01/src/main/kotlin/Clientes/Cliente.kt#L5

   - Enum class TipoPoliza: enumera los distintos tipos de pólizas disponibles.
   https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/fa278d5715064a75dd0c0eb6942cb16cf3b83366/src/main/kotlin/Polizas/TipoPoliza.kt#L2-L5

  Usando estas clases de ejemplo, contribuyen significativamente a la solución del problema abordado por la aplicación, ya que proporcionan una estructura clara y coherente para representar la información de los clientes y los tipos de pólizas.

  

#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.h, 4.j, 7.a, 7.b, 7.c)**: Describe sobre tu código cómo has implementado la herencia o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? ¿Mostrando tu código, contesta a qué principios has utilizado y qué beneficio has obtenido?

  -**Herencia y/o uso de interfaces**
     En la herencia se ha utilizado para representar diferentes tipos de pólizas de seguro. Cada una hereda de una clase base común 'Póliza' la cual permite compartir funcionalidades y comportamientos comunes entre ellas. Con esta herencia se facilita la extensión de la aplicación.
     Se usa la interfaz Menu para definir unos métodos comunes para los diferentes menús del proyecto.
     Este enfoque facilita la reutilización del código , le da flexibilidad con el uso de la interfaz y una gran facilidad de mantenimiento.
  
   -**Principios Solid**
      -*SRP* - Principio de responsabilidad única. 
      En este proyecto, cada clase tiene una responsabilidad clara y específica.
      Por ejemplo, la clase GestionClientes se encarga de la gestión de clientes, mientras que las clases PolizaMoto, PolizaHogar, etc., se ocupan de la gestión de diferentes tipos de pólizas.
      https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/fc4e5d264fd99a6cc2ed224b878ccb8b30b3cebc/src/main/kotlin/Clientes/GestionClientes.kt#L10-L77
      https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/fc4e5d264fd99a6cc2ed224b878ccb8b30b3cebc/src/main/kotlin/Polizas/PolizaMoto.kt#L6-L52

   -*OCP* - Principio de Abierto/Cerrado.
      Este principio sugiere que las entidades de software deben estar abiertas para la extensión pero cerradas para la modificación.
      En el proyecto, este principio se aplica en las clases de gestión de pólizas (PolizaMoto, PolizaHogar, etc.). Cada una de estas clases es fácilmente extensible para agregar nuevos tipos de pólizas sin modificar el código existente. Por ejemplo, si se quiere agregar una nueva póliza de salud, se puede crear una nueva clase PolizaSalud sin modificar las clases existentes.

   -*LSP* - Principio de Sustitución de Liskov.
      Este principio establece que los objetos de un programa deben ser reemplazables por instancias de sus subtipos sin alterar la corrección del programa.
      En el proyecto, la herencia se utiliza de manera efectiva para representar diferentes tipos de pólizas (PolizaMoto, PolizaHogar, etc.) que comparten ciertas características y comportamientos comunes pero también tienen comportamientos específicos.
      https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/fc4e5d264fd99a6cc2ed224b878ccb8b30b3cebc/src/main/kotlin/Polizas/Poliza.kt#L9-L25
      https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/fc4e5d264fd99a6cc2ed224b878ccb8b30b3cebc/src/main/kotlin/Polizas/PolizaHogar.kt#L10-L61

   -*ISP* - Principio de Segregación de Interfaces.
      Este principio sugiere que los clientes no deben verse obligados a depender de interfaces que no utilizan.
      En el proyecto, se utilizan interfaces como Menu para definir comportamientos comunes a diferentes tipos de menús. Esto permite que los menús específicos implementen solo los métodos que necesitan, evitando la dependencia de funcionalidades no utilizadas.
      https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/fc4e5d264fd99a6cc2ed224b878ccb8b30b3cebc/src/main/kotlin/Menus/Menu.kt#L6-L13
      https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/fc4e5d264fd99a6cc2ed224b878ccb8b30b3cebc/src/main/kotlin/Menus/MenuClienteExist.kt#L3-L18

#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?

  Para explicar la jerarquía de clases usada en este proyecto utilizare de ejemplo la clase abstracta Póliza y las distintas clases que derivan de ellas
  https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/2116602827d345444b8225a9386c8430944d6d74/src/main/kotlin/Polizas/Poliza.kt#L8-L10
  https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/2116602827d345444b8225a9386c8430944d6d74/src/main/kotlin/Polizas/PolizaCoche.kt#L5-L7
  Además la subclase pólizaVida que hereda de póliza tambien es una clase padre para la clase poliza Deceso haciendo que esta comparta tanto los métodos de la clase póliza como los de la clase vida
  https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/2116602827d345444b8225a9386c8430944d6d74/src/main/kotlin/Polizas/PolizaVida.kt#L10-L12
  https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/2116602827d345444b8225a9386c8430944d6d74/src/main/kotlin/Polizas/PolizaDeceso.kt#L4-L6

  En cuanto al tipo de herencia, principalmente se utiliza la especialización y extensión, ya que cada una de las distintas clases de seguros son extensiones especializadas de la clase abstracta Poliza. Cada una de estas clases especializa el el comportamiento en funcion del tipo específico de póliza que representa.

#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.k)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.

  He implementado la librería de junit para la realización del test que compruebe la funcionalidad de algunas funciones de mi código y que funcione correctamente.
  https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/2116602827d345444b8225a9386c8430944d6d74/src/test/kotlin/test/GestionClientesTest.kt#L2-L17

#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?

  https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/9d64725295b46c49e7a27a5651d810034f2a5fbe/src/main/kotlin/Clientes/GestionClientes.kt#L86-L94
  El código ha sido documentado con la documentación correspondiente de Kotlin(KDoc). Como herramienta externa para facilitar y aligerar este proceso he utilizado la IA de ChatGpt.
  La documentación proporciona una pequeña descripción del funcionamiento de cada función y/o clase, además de comentarios adicionales en los puntos que considero que deben ser aclarados.

#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?

  He implementado el genérico en la interfaz de menú, en el método de respuesta para que según el tipo de menú puede variar el tipo de dato de la respuesta. El genérico le proporciona flexibilidad al código, ya que se puede usar cualquier tipo de dato.
    https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/4aab34122632a43d4916b3348ba24a1fb4ec845a/src/main/kotlin/Menus/Menu.kt#L3-L8
  También en la clase que gestiona la consola.
  https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-lnarote777/blob/2116602827d345444b8225a9386c8430944d6d74/src/main/kotlin/Consola.kt#L5-L16


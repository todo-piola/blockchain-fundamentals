# KaribiaChain

**KaribiaChain** es una blockchain educativa implementada en **Java**.  
El objetivo del proyecto es comprender los conceptos básicos detrás de una blockchain: bloques, hashing, prueba de trabajo (PoW) y validación de la cadena.

Este proyecto parte de un [tutorial de Medium](https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa), pero ha sido adaptado y extendido para mi propio aprendizaje.

---

##  Características
- Creación de bloques enlazados mediante hashes.
- Implementación de **Prueba de Trabajo (Proof of Work)** con dificultad configurable.
- Validación completa de la blockchain.
- Exportación de la blockchain a un archivo JSON.
- Uso de **SHA-256** para el hashing.

---

##  Estructura del proyecto
- `Block.java` → Clase que representa un bloque de la cadena.
- `Encriptacion.java` → Clase auxiliar para aplicar SHA-256.
- `KaribiaChain.java` → Clase principal que construye la blockchain, mina bloques y valida la cadena.

---

##  Mejoras realizadas sobre el tutorial
- Código comentado y explicado en español.
- Nombres de clases y variables adaptados.
- Dificultad configurada desde la clase principal.
- Función para exportar la blockchain a **JSON**
- Documentación

---

## 📄 En este proyecto aprendí
- Cómo funciona el hashing con SHA-256 en Java.
- La importancia del nonce ('number used once') para variar el hash y lograr la prueba de trabajo.
- Cómo validar una blockchain asegurando la integridad de los bloques.
- Uso de Gson para serializar objetos a JSON.

---

## Futuras mejoras e implementaciones (próximamente)
- Añadir una clase Transaccion para almacenar varias transacciones por bloque.
- Guardar la blockchain en una base de datos.
- Implementar una pequeña API REST para consultar la blockchain.
- Visualización web de la cadena en un explorador de bloques sencillo.

# ✈️ Sistema de Gestión de Vuelos basado en Árboles AVL

## 📚 Propósito del Proyecto
El objetivo de este proyecto es aplicar los conceptos de **árboles binarios de búsqueda balanceados (AVL)** para desarrollar un sistema que permita **registrar, buscar, eliminar y visualizar vuelos**, manteniendo la estructura equilibrada para optimizar las operaciones de búsqueda y gestión de datos.

## 🎬 Video demostrativo

[![Ver video en YouTube](([https://www.youtube.com/watch?v=TU_LINK_AQUI](https://youtu.be/suDNTPNWfZs?si=uUsKyiLwLLq0Pshy))


---

## 👥 Integrantes del Equipo
- 🧑‍💻 **Sebastián Bohórquez**  
- 🧑‍💻 **José Pacheco**

---

## ⚙️ Lenguaje y Entorno de Desarrollo
- 💻 **Lenguaje:** Java  
- 🧩 **Entorno:** Visual Studio Code  
- ☕ **Versión de Java recomendada:** JDK 17 o superior

---

## 🧩 Descripción General
El sistema simula una base de datos de vuelos utilizando un **árbol AVL**, donde cada nodo representa un vuelo con la siguiente información:

| Campo | Descripción |
|--------|--------------|
| ✈️ Número de vuelo | Identificador único del vuelo |
| 🌆 Origen | Ciudad de salida |
| 🏙️ Destino | Ciudad de llegada |
| 🕓 Hora de salida | Hora programada |
| 🏢 Aerolínea | Empresa que opera el vuelo |

El árbol se mantiene **balanceado automáticamente**, garantizando operaciones rápidas y eficientes.

---

## 🖥️ Funcionalidades del Sistema

🔹 **1. Registrar nuevo vuelo**  
Permite ingresar los datos de un nuevo vuelo y lo inserta en el árbol AVL, aplicando las rotaciones necesarias.

🔹 **2. Buscar vuelo**  
Permite buscar un vuelo por su número y mostrar su información si existe.

🔹 **3. Eliminar vuelo**  
Elimina un vuelo del árbol manteniendo el equilibrio del mismo.

🔹 **4. Mostrar vuelos (Recorridos)**  
Permite visualizar los vuelos almacenados mediante tres recorridos:
- 🟩 **InOrden:** Muestra los vuelos ordenados por número.  
- 🟨 **PreOrden:** Muestra la raíz y luego los subárboles.  
- 🟥 **PostOrden:** Muestra primero los subárboles y luego la raíz.  

🔹 **0. Salir**  
Finaliza la ejecución del programa.

---

## 🧠 Ejemplo de Ejecución

### ✈️ Vuelos registrados
Vuelo #100 — Bogotá → Medellín — 10:00 — Avianca

Vuelo #105 — Medellín → Bogotá — 11:00 — VivaAir

Vuelo #110 — Cali → Cartagena — 12:30 — LATAM

Vuelo #115 — Pereira → Medellín — 10:50 — Satena

Vuelo #120 — Barranquilla → Cali — 13:45 — Avianca


---

## 🎬 Video Demostrativo
📹 El video tiene una duración aproximada de **5 minutos** e incluye:

- Explicación general del funcionamiento del sistema.  
- Ejecución práctica mostrando el registro, búsqueda, eliminación y visualización de vuelos.  
- Participación activa de ambos integrantes en la presentación.

---

## 💡 Conclusión
Este proyecto demuestra cómo los **árboles AVL** pueden aplicarse en sistemas reales para mantener la **eficiencia en la gestión de datos**, garantizando que las operaciones de inserción, búsqueda y eliminación se realicen en **tiempo logarítmico (O(log n))**.

---

## 🧰 Tecnologías Utilizadas
| Tecnología | Descripción |
|-------------|--------------|
| ☕ Java | Lenguaje de programación principal |
| 🧑‍💻 Visual Studio Code | Entorno de desarrollo |
| 🧮 Estructura de Datos | Árbol AVL implementado manualmente |

---

## 🏁 Resultado Final
Un **sistema funcional, optimizado y escalable** que permite administrar información de vuelos mediante estructuras de datos balanceadas, ideal como ejemplo académico de aplicación de **Árboles AVL en Java**.

---

### 🚀 *"Estructura, equilibrio y eficiencia: así vuelan nuestros datos."*

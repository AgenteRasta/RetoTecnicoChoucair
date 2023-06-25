Feature: Comprar varios productos
  yo como usuario que ingresa a la pagina del exito
  quiero elegir un categoria y subcategoria
  para comprar varios productos y cantidades

  Scenario Outline: compra de varios productos
    Given que el usuario esta en la pagina del exito
    When selecciona una <categoria> y una <subcategoria>
    And aniade cinco productos al carrito con sus respectivas cantidades
    And entra al carrito de compras y registra un <correo>
    Then visualiza toda la informacion de la compra
    Examples:
      | categoria    | subcategoria          | correo             |
      | "Dormitorio" | "Cabeceros"           | "prueba@gmail.com" |
      | "Dormitorio" | "Colchones sencillos" | "prueba@gmail.com" |

Feature: Registro login y compra
  yo como usuario de la app del exito
  quiero registrarme e iniciar sesion
  para agregar productos al carrito

  Scenario Outline: registro login y carrito
    Given que estoy en la app del exito
    When registro una cuenta con <nombre> <apellido> <cedula> <dia> <mes> <anio> <celular> <correo>
    And inicio sesion con la cuenta recien registrada
    And agrego un producto al carrito
    Then puedo observar el producto en el carrito
    Examples:
      | nombre    | apellido  | cedula     | dia  | mes  | anio   | celular   | correo                   |
      | "Prueba1" | "Prueba1" | "12345678" | "01" | "01" | "1990" | "3265988" | "estiven.tr96@gmail.com" |
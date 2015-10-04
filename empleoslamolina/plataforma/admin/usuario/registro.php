<?php
require_once("../../../BL/BLperfil.php");
fnSessionStart();
$conexion = conectar_cms();
$usuario = $_SESSION["usuario"]; 
$arr_perfiles = dame_perfiles();
error_reporting(0);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AGENCIA DE EMPLEOS LA MOLINA | Plataforma de Servicios</title>
<style>
@import url("../../estilos.css");
</style>
</head>

<body>
<table width="100%" height="91" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30" colspan="2" align="left" valign="middle" bgcolor="#f7d418" class="textoplomotitulo">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="19" align="center">&nbsp;</td>
        <td width="86" align="left" valign="middle"><strong class="negrita14">Usuarios</strong></td>
        <td width="1195" align="right" valign="middle" class="negrita14">Registrar Usuario</td>
        <td width="20" align="right" valign="middle">&nbsp;</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td height="2" colspan="2" align="left" valign="top" bgcolor="1d2702"></td>
  </tr>
  <tr>
    <td height="28" colspan="2" align="left" valign="middle">
    <table width="554" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" align="center">&nbsp;</td>
        <td width="542" align="left" valign="middle">
        <span class="texto">En esta sección podrás registrar un nuevo usuario en el 
        sistema</span>
        </td>
        </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td width="1301" height="23" align="right" valign="middle" bgcolor="#CCCCCC" class="linkblanco">
    <a href="administrar.php" class="vinculo">Administrar Usuarios</a></td>
    <td width="19" align="left" valign="middle" bgcolor="#CCCCCC" class="cabeceratabla">&nbsp;</td>
  </tr>
  <tr>
    <td height="5" colspan="2" align="left" valign="top"></td>
  </tr>
</table>
  <table width="100%" height="460" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="370" colspan="2" align="center" valign="top">
    <form id="form" name="form" method="post" action="proc_registrar_usuario.php">
      <table width="781" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="39" colspan="3" align="left" valign="middle" class="cajatextooscuro">
          <strong class="textoverde">DATOS DE ACCESO</strong></td>
        </tr>
        <tr>
          <td height="20" align="left" valign="middle" class="cajatextooscuro"><strong>Usuario (*)</strong></td>
          <td width="218" height="20" align="left" valign="middle" class="cajatextooscuro"><strong>Password (*)</strong></td>
          <td width="250" align="left" valign="middle" class="cajatextooscuro"><strong>Perfil (*)</strong></td>
        </tr>
        <tr>
          <td align="left" valign="top" class="textoplomonegrita">
          <input name="usuario" type="text" class="cajatexto" id="usuario" size="30" maxlength="30" tabindex="1"/>
          </td>
          <td align="left" valign="top" class="textoplomonegrita">
          <input name="password" type="password" class="cajatexto" id="password" tabindex="2" size="30" 
          maxlength="30"/>
          </td>
          <td align="left" valign="top" class="textoplomonegrita">
          <select name="perfil" class="listagris" id="perfil" tabindex="3">
           <option value="-1">-------- Seleccione un perfil -------- </option>
           <?php
		   $totalperfiles = sizeof($arr_perfiles);
		   for($i=0; $i<$totalperfiles; $i++)
		   {
		   ?>
           <option value="<?php echo($arr_perfiles[$i][0]); ?>"><?php echo($arr_perfiles[$i][1]); ?></option>
		   <?php
		   }
		   ?>
          </select>
          </td>
        </tr>
        <tr>
          <td height="39" colspan="3" align="left" valign="middle" class="cajatextooscuro">
          <strong class="textoverde">DATOS PERSONALES</strong></td>
        </tr>
        <tr>
          <td width="217" height="20" align="left" valign="middle" class="cajatextooscuro"><strong>Nombres (*)</strong></td>
          <td align="left" valign="middle" class="cajatextooscuro"><strong>Apellido Paterno (*)</strong></td>
          <td width="250" align="left" valign="middle" class="cajatextooscuro"><strong>Apellido Materno (*)</strong></td>
        </tr>
        <tr>
          <td height="20" align="left" valign="middle">
          <input name="nombre" type="text" class="cajatexto" id="nombre" tabindex="4" size="30"/>
          </td>
          <td align="left" valign="middle">
          <input name="ape_paterno" type="text" class="cajatexto" id="ape_paterno" tabindex="5" size="30"/>
          </td>
          <td align="left" valign="middle">
          <input name="ape_materno" type="text" class="cajatexto" id="ape_materno" tabindex="6" size="30"/>
          </td>
        </tr>
        <tr>
          <td height="20" align="left" valign="middle" class="cajatextooscuro"><strong>Tel&eacute;fono</strong></td>
          <td align="left" valign="middle" class="cajatextooscuro"><strong>Email (*)</strong></td>
          <td align="left" valign="middle" class="cajatextooscuro"><strong>Direcci&oacute;n</strong></td>
        </tr>
        <tr>
          <td align="left" valign="middle">
          <input name="telefono" type="text" class="cajatexto" id="telefono" tabindex="7" size="30"/>
          </td>
          <td align="left" valign="middle">
          <input name="email" type="text" class="cajatexto" id="email" tabindex="8" size="30"/>
          </td>
          <td align="left" valign="middle">
          <input name="direccion" type="text" class="cajatexto" id="direccion" tabindex="9" size="30"/>
          </td>
        </tr>
      </table>
      <br />
      <table width="685" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="685" height="37" align="center" valign="bottom">
          <input name="button" type="submit" class="cajabotones" id="button" value="Registrar" 
          onclick="return validar();" tabindex="10"/>
          </td>
        </tr>
      </table>
    </form>
    </td>
  </tr>
</table>
</body>
</html>
<script>
function validar()
{
 if(form.ape_paterno.value=="" || form.ape_materno.value=="" || form.nombre.value=="" || form.usuario.value=="" 
    || form.password.value=="" || form.perfil.value=="-1" || form.email.value=="")  
 {
   alert("Complete todos los campos");
   if(form.ape_paterno.value==""){form.ape_paterno.style.backgroundColor = '#f8a5ad';} 
   if(form.ape_materno.value==""){form.ape_materno.style.backgroundColor = '#f8a5ad';}
   if(form.nombre.value==""){form.nombre.style.backgroundColor = '#f8a5ad';}
   if(form.usuario.value==""){form.usuario.style.backgroundColor = '#f8a5ad';}
   if(form.password.value==""){form.password.style.backgroundColor = '#f8a5ad';}
   if(form.perfil.value=="-1"){form.perfil.style.backgroundColor = '#f8a5ad';} 
   if(form.email.value==""){form.email.style.backgroundColor = '#f8a5ad';}
   return false;
 }
 else
 {
   return true;
 }	
}
</script>
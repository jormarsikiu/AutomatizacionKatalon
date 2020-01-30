<?xml version="1.0" encoding="UTF-8"?>
<WebElementEntity>
   <description></description>
   <name>div_bootstrap-select  select          displ_91fa22</name>
   <tag></tag>
   <elementGuidId>1f4eb594-bfa4-4e76-83a5-db6746e99bb9</elementGuidId>
   <selectorCollection>
      <entry>
         <key>XPATH</key>
         <value>//div[@id='page-wrapper']/div/div</value>
      </entry>
   </selectorCollection>
   <selectorMethod>XPATH</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>tag</name>
      <type>Main</type>
      <value>div</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>container body-content</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>
                        



    .bootstrap-select > select {
         display: none !important; 
    }
    #buscador .col-md-3 {
        width: 33.33%;
    }
    .combo-cliente {
        width: auto !important;
        background-color: #fff;
        background-image: none;
        /*border: 1px solid #ccc;*/
        border-radius: 4px;
    }
    /*#prod_order button{width:100px!important;}*/



    Inicio
    
        Orden de Producción
    


Orden de Producción




    

    
        
        
    
    
        
            
                
                    ×    Información básica 
                
                
                    
                        La página muestra la información general de los pedidos de combustible que se han realizado y el estatus de los mismos. Es posible realizar pedidos de combustible tipo RACK o en destino, además de eliminar y modificar los pedidos registrados. 
                    


                    
                    
                    
                    Añadir un pedido de combustible tipo RACK o en destino según sea el caso.
                    

                    
                    Filtrar la información de un pedido de combustible a partir del nombre del cliente y un intervalo de fechas.
                    

                    
                    Modificar la información asociada a un pedido de combustible.
                    

                    
                    Eliminar un pedido de combustible registrado.
                    

                
                
                     Aceptar
                
            
        
    




    
        Cliente
        001008-Yackson Rincón Seleccione001008-Yackson Rincón001000-Sumatec001004-Inversiones La Rosa MísticaSeleccione
001008-Yackson Rincón
001000-Sumatec
001004-Inversiones La Rosa Mística

        
    

    
        Orden de Producción
        125 Seleccione125111307128Seleccione
125
111
30
7
128

        
    
    
        Estatus
        Seleccione SeleccioneCertificadoEn producciónProducidoSeleccione
Certificado
En producción
Producido


        
        
    
    
        
            Creados desde:
            
        
        
            Creados hasta:
            
        
    

    
         Buscar
    





     Orden de Producción (5)
    
        
            
                
                    Nro.
                
                
                    Cliente
                
                
                    Fecha de Creación
                
                
                    Fecha estimada de despacho
                
                
                    Estatus
                
                
                    Opciones
                
            
        
        
                
                    
                        125
                    
                    
                        001008 - Yackson Rincón
                    
                    
                        24/01/2020
                    
                    
                        13/02/2020
                    

                    
                        
                                
                        
                    

                    
                        
                        
                            
                        
                    

                
                
                    
                        111
                    
                    
                        001000 - Sumatec
                    
                    
                        22/01/2020
                    
                    
                        06/02/2020
                    

                    
                        
                                
                        
                    

                    
                        
                        
                            
                        
                    

                
                
                    
                        30
                    
                    
                        001000 - Sumatec
                    
                    
                        13/12/2019
                    
                    
                        31/12/2019
                    

                    
                        
                                
                        
                    

                    
                        
                        
                            
                        
                    

                
                
                    
                        7
                    
                    
                        001008 - Yackson Rincón
                    
                    
                        10/12/2019
                    
                    
                        25/12/2019
                    

                    
                        
                                
                        
                    

                    
                        
                        
                            
                        
                    

                
                
                    
                        128
                    
                    
                        001004 - Inversiones La Rosa Mística
                    
                    
                        24/01/2020
                    
                    
                        08/02/2020
                    

                    
                        
                                
                        
                    

                    
                        
                        
                                
                        
                    

                
        

    


«1»



    function EnviarFiltro() {
        $(&quot;#frm&quot;).submit();
        }

    var lang = window.navigator.userLanguage || window.navigator.language;
    var ln = 'en';
    $.datepicker.setDefaults($.datepicker.regional[ln]);
    $(function () {
            $(&quot;#DESDE&quot;).datepicker({ dateFormat: 'dd/mm/yy', minDate: '-3600D' });
            $(&quot;#HASTA&quot;).datepicker({ dateFormat: 'dd/mm/yy', minDate: '-360D' });

        $(&quot;#side-menu li.active&quot;).removeClass(&quot;active&quot;);
    });
    // quitar la validación para que trabaje en G Chrome
    $(&quot;#DESDE&quot;).removeAttr(&quot;data-val-date&quot;);
    $(&quot;#HASTA&quot;).removeAttr(&quot;data-val-date&quot;);



    function Filtrar_Solicitud_Pedidos() {
        $(&quot;#frm&quot;).submit();
    }

    $(&quot;#DESDE&quot;).attr(&quot;autocomplete&quot;, &quot;off&quot;);
    $(&quot;#HASTA&quot;).attr(&quot;autocomplete&quot;, &quot;off&quot;);

    




                            
                                
                            
                        
                    </value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath</name>
      <type>Main</type>
      <value>id(&quot;page-wrapper&quot;)/div[@class=&quot;container-fluid&quot;]/div[@class=&quot;container body-content&quot;]</value>
   </webElementProperties>
   <webElementXpaths>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:idRelative</name>
      <type>Main</type>
      <value>//div[@id='page-wrapper']/div/div</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:position</name>
      <type>Main</type>
      <value>//div/div/div/div</value>
   </webElementXpaths>
</WebElementEntity>

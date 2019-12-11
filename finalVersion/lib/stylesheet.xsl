<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:template match="/">
      <html>
      <style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

table {
    border-spacing: 0;
}
th, td {
    border: 1px solid #000;
    padding: 0.5em 1em;
}
/* the first 'th' within the first 'tr' of the 'thead': */
thead tr:first-child th:first-child {
    border-radius: 0.6em 0 0 0;
}
/* the last 'th' within the first 'tr' of the 'thead': */
thead tr:first-child th:last-child {
    border-radius: 0 0.6em 0 0;
}
/* the first 'td' within the last 'tr' of the 'tbody': */
tbody tr:last-child td:first-child {
    border-radius: 0 0 0 0.6em;
}
/* the last 'td' within the last 'tr' of the 'tbody': */
tbody tr:last-child td:last-child {
    border-radius: 0 0 0.6em 0;
}

</style>
         <body>
            <h1>players from xml file</h1>
            <table border="1" id="customers">
               <tr>
                  <th>first name</th>
                  <th>last name</th>
                  <th>age</th>
                  <th>id</th>
                  <th>team</th>
               </tr>
               <xsl:for-each select="basketball/player">
                  <tr>
                     <td>
                        <xsl:value-of select="name/firstname" />
                     </td>
                     <td>
                        <xsl:value-of select="name/lastname" />
                     </td>
                     <td>
                        <xsl:value-of select="age" />
                     </td>
                     <td>
                     	<xsl:value-of select="@id" />	
                     </td>
                     <td>
                     	<xsl:value-of select="team_ref/@idref" />	
                     </td>
                  </tr>
               </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>
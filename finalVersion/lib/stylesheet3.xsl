<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>

	<xsl:key name="preg" match="person" use="@id" />

	<xsl:template match=".">
		<xsl:for-each select="//team[id='OKC']/player_ref">
			<xsl select="key('preg',@idref)">
				<xsl:value-of select="name/lastname" />
			</xsl>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>
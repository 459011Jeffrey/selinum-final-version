<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">
    <xsl:template match="text()" /> 
    <xsl:strip-space elements="*"/>  
    <xsl:template match="/">
        <html>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="team/team_name">
        <xsl:text>&#xa;</xsl:text>          
            <i><xsl:value-of select="."/></i>
        <xsl:text>&#xa;</xsl:text>
    </xsl:template>
    <xsl:template match="team/player_ref[1]">
        <xsl:variable name="lookup" select="@*"/>
        <xsl:value-of select="../../id($lookup)/name"/>
    </xsl:template>
    <xsl:template match="team/player_ref[position()>1]">
        <xsl:variable name="lookup" select="@*"/>
        , <xsl:value-of select="../../id($lookup)/name"/>
    </xsl:template>
</xsl:stylesheet>

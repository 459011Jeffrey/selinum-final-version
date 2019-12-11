<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="team/team_name">
        <i><xsl:value-of select="."/></i>
    </xsl:template>
    <xsl:template match="team/player_ref[1]">
        <xsl:value-of select="id(@*)"/>
    </xsl:template>
    <xsl:template match="team/player_ref[position()>1]">
        ,<xsl:value-of select="@*"/>
    </xsl:template>
</xsl:stylesheet>
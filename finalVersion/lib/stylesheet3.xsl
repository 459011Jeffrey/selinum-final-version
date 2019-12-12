<?xml version="1.0" encoding="UTF-8"?>
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
    <xsl:template match="team/player_ref[position()!=last()]">
        <xsl:variable name="lookup" select="@*"/>
        <xsl:value-of select="../../player/id($lookup)/name/firstname"/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="../../player/id($lookup)/name/lastname"/>,                 <!-- <xsl:text>, </xsl:text> -->
    </xsl:template>
    <xsl:template match="team/player_ref[position()=last()]">
        <xsl:variable name="lookup" select="@*"/>
        <xsl:value-of select="../../player/id($lookup)/name/firstname"/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="../../player/id($lookup)/name/lastname"/>
    </xsl:template>
</xsl:stylesheet>
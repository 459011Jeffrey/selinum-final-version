<basketball>
{for $p in doc("lib/file.xml")/basketball/player
where $p/team_ref/@idref = "CHI" and $p/age>25
return ($p/name, $p/games_played)}
</basketball>
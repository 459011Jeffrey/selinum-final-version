<basketball>
{for $p in doc("lib/file.xml")/basketball/player
where $p/team_ref/@idref = "CHI"
return $p/name}
</basketball>
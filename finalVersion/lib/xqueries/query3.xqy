<basketball>
{for $c in doc("lib/file.xml")/basketball/coach
where $c/performance/ratio>0.5 
return <result> {($c/name, $c/performance/ratio, 
for $t in /basketball/team
where $t/coach_ref/@idref=$c/@id 
return $t/team_name)}
</result> }
</basketball>
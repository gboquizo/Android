<?php
header( 'Content-Type:text/xml' );
$dd = new PDO('mysql:host=localhost;dbname=bd_conecta4','root','root');
$sql = 'INSERT INTO games VALUES (0,0)';
$sth = $dd->prepare($sql);
$sth->execute( array() );
$qid = $dd->lastInsertId();

$doc = new DOMDocument();
$r = $doc->createElement( "game" );
//añadir el resto de atributos: turno y estado
$r->setAttribute( 'id', $qid );
$doc->appendChild( $r );
print $doc->saveXML();
?>
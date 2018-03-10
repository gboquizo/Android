<?php
header( 'Content-Type:text/xml' );
$dbh = new PDO('mysql:host=localhost;dbname=bd_conecta4','root','root');
$sql = 'SELECT * FROM games';
$q = $dbh->prepare( $sql );
$q->execute( array() );

$doc = new DOMDocument();
$r = $doc->createElement( "games" );
$doc->appendChild( $r );
foreach ( $q->fetchAll() as $row) {
	$e = $doc->createElement( "game" );
	$e->setAttribute( 'id', $row['ID'] );
	$r->appendChild( $e );
}
print $doc->saveXML();
?>
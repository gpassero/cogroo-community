<script src="<c:url value='/js/jquery.twitter.search.js' />" type="text/javascript" ></script>
<script src="<c:url value='/js/jquery.zrssfeed.js' />" type="text/javascript" ></script>

<c:if test="${justRegistered}">
	<script type="text/javascript">_gaq.push(['_trackEvent', 'Register', 'succeeded register', '${login}']);</script>
</c:if>

<c:if test="${justLogged}">
	<script type="text/javascript">_gaq.push(['_trackEvent', 'Login', 'succeeded login', '${login}']);</script>
</c:if>

<script type="text/javascript"><!--//--><![CDATA[//><!--

	$(document).ready(function(){

		$('#twitter').twitterSearch({
			term: 'cogroo',
			title: 'Siga @cogroo no Twitter',
			avatar:  false, 
			titleLink: 'http://twitter.com/cogroo',
			birdLink: 'http://twitter.com/cogroo',
			css: {
				img: { width: '30px', height: '30px' }
				}
			}); 
		
		$('#news').rssfeed('http://ccsl.ime.usp.br/cogroo/pt-br/rss.xml', {
		    limit: 6,
		    date: false,
		    content: true,
		    snippet: true,
		    errormsg: 'N�o foi poss�vel abrir not�cias.'
		  });
	});
	
//--><!]]>

</script>
		
		<div id="socialNetworks" class="socialNetworks" style="margin-top:20px; margin-left:20px">
			<iframe src="http://www.facebook.com/plugins/likebox.php?href=http%3A%2F%2Fwww.facebook.com%2Fpages%2FCoGrOO%2F191205774239878&amp;width=240&amp;colorscheme=light&amp;show_faces=true&amp;stream=false&amp;header=false&amp;height=180" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:240px; height:180px;" allowTransparency="true"></iframe>		
			<br /><br />
			<div id="twitter" class="twitter"></div>
			
		</div>
		
		<h2>Sobre o projeto</h2>
		
		<p>O CoGrOO Comunidade � um portal colaborativo para aprimorar o CoGrOO, o corretor gramatical em portugu�s para BrOffice. <a href="<c:url value="/about"/>">Mais informa��es...</a></p>
		<br />
		<p><a href="<c:url value="/grammar"/>">Busque</a> erros gramaticais em uma frase. Algo estranho? Conte para n�s!</p>
		<br />
		
		
	
		<h2>Not�cias</h2>
		
		<div id="newswrapper">
			<div id="news"></div>
		</div> 
var tdAll = document.getElementsByTagName("td");

var gameImg = [ "apple.jpg", "banana.jpg", "grape.jpg", "kiwi.jpg",
		"mango.jpg", "melon.jpg", "orange.jpg", "pear.jpg", "peach.jpg",
		"pineapple.jpg", "tomato.jpg", "watermelon.jpg" ,
		"1.jpg", "2.jpg", "3.jpg", "4.jpg",
		"5.jpg", "6.jpg", "7.jpg", "8.jpg", "9.jpg",
		"10.jpg", "11.jpg", "12.jpg" , "13.jpg" , "14.jpg" ,
		"15.jpg" , "16.jpg" , "17.jpg" , "18.jpg" , "19.jpg",
		"20.jpg" , "21.jpg" , "22.jpg" , "23.jpg"];

var makeNumber = 0;
var count = 0;
var count2 = 0;
var firstCard = 0;
var secondCard = 0;
var matchCount = 0;
var clickCount = 0;
var ok = [];

function start() {

	if (confirm("Game Start?") == true) {
		alert("Play Game~~^ ^*");
		ok = [];
		
		for (var bgr = 0; bgr < tdAll.length; bgr++) {
			tdAll[bgr].style.backgroundImage = '';
		}
		
		matchCount = 0;
		shuffle();
		
	} else {
		alert("Press to start game");
	}
}

function shuffle() {

	for (var shuffle = 0; shuffle < tdAll.length; shuffle++) {

		makeNumber = parseInt(Math.random() * 35);

		for (var shuflle2 = 0; shuflle2 < ok.length; shuflle2++) {

			if (ok[shuflle2] == makeNumber) {
				count++;
			}
		}

		if (count >= 2) {
			shuffle--;
		} else {
			ok[shuflle2] = makeNumber;
		}

		count = 0;

	}
	goGame();
}

function goGame() {

	for (var i = 0; i < tdAll.length; i++) {

		tdAll[i].id = ok[i];
		tdAll[i].name = i;
		
		tdAll[i].onclick = function() {

			if (count2 >= 1) {
				secondCard = this.name;
				this.style.backgroundImage = "url(" + gameImg[ok[secondCard]] + ")";
				clickCount++;
				if(firstCard == secondCard){
					count=0;
					return goGame();
				}

				if (tdAll[secondCard].id != tdAll[firstCard].id) {
					setTimeout(function() {
						tdAll[secondCard].style.backgroundImage = '';
						tdAll[firstCard].style.backgroundImage = '';
					}, 200);
				} else {

					matchCount++;

					tdAll[firstCard].onclick = null;
					tdAll[secondCard].onclick = null;
					if (matchCount == 35){
						setTimeout(function() {
							alert("The End~~ Bye~~ ^ ^* \n Total Count = " + clickCount);
						}, 200);
					}
					
				}
				count2 = 0;
			} else {
				firstCard = this.name;
				this.style.backgroundImage = "url(" + gameImg[ok[firstCard]] + ")";
				
				count2++;
			}
		}
	}
}
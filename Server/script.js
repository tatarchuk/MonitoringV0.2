

var iconTracker = 's';

function playControl()
    {
	mySound=document.getElementById("sound");
        mySound.volume=0.7;
	button=document.getElementById("control");
	button.addEventListener('click', turn);
      
    }

function turn() {
	
	if(!mySound.paused) {
	  mySound.pause();
	  changeIcon();
	} else {
	  mySound.play();
	   changeIcon();
	}
}

function changeIcon()
    {
        var icon=document.getElementById("soundIcon");
	if (iconTracker === 's') {
	  icon.src="resources/nonsound.png";
	  iconTracker = 'n';
	} else {
	  icon.src="resources/sound.png";
	  iconTracker = 's';
	}
    }

    window.addEventListener('load', playControl, false);
    
       
  
  
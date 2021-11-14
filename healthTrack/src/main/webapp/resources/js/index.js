let map;
let markers = [];

$( function() {
   $(".godown").click(function(){
        if($(".painel").css("height") == "40px"){
            $(".painel").css("height","65%")    
            $(".godown").css("height","10%")
        }
        else{
            $(".godown").css("height",40)
            $(".painel").css("height",40)
        }    
   })
});



function setMap(position) {
    loadMap(position.coords.latitude,position.coords.longitude,16) 
}

function error(error) {
    console.log(error);
    loadMap();
}

function addMarker(position) {
    const marker = new google.maps.Marker({
      position,
      map,
    });  
    markers.push(marker);
}

function setMapOnAll(map) {
    for (let i = 0; i < markers.length; i++) {
      markers[i].setMap(map);
    }
}

function showMarkers() {
    setMapOnAll(map);
}

function hideMarkers() {
    setMapOnAll(null);
}

function deleteMarkers() {
    hideMarkers();
    markers = [];
}
var testApp = angular.module("testApp", ['ngRoute']);

testApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/',{
        templateUrl: '/app/html/skakaonice.html'
    }).when('/takmicar/edit/:id',{
        templateUrl: '/app/html/edit-takmicar.html'
    }).when('/takmicar/add',{
        templateUrl: '/app/html/takmicar-add.html'
    }).when('/takmicar/skok/:id',{
        templateUrl: '/app/html/skok-add.html'
    }).when('/takmicar/skokovi/:id',{
        templateUrl: '/app/html/skokovi-takmicara.html'
    }).otherwise({
        redirectTo: '/'
    });
}]);

testApp.controller("skakaoniceCtrl", function($scope, $http, $location){

	var baseUrlTakmicari = "/api/takmicari";
    var baseUrlSkakaonice = "/api/skakaonice";
    var baseUrlSkok = "/api/skokovi";
    

    $scope.pageNum = 0;
    $scope.totalPages = 0;

    $scope.takmicari = [];
    $scope.skakaonice = [];
    $scope.skokovi = null;

    $scope.trazeniTakmicar = {};
    $scope.trazeniTakmicar.skakaonicaId = "";
    $scope.trazeniTakmicar.imePrezime = "";
    $scope.trazeniTakmicar.drzava = "";
    
    

    var getTakmicari = function(){

        var config = {params: {}};

        config.params.pageNum = $scope.pageNum;

        if( $scope.trazeniTakmicar.skakaonicaId != ""){
            config.params.skakaonicaId =  $scope.trazeniTakmicar.skakaonicaId;
        }

        if( $scope.trazeniTakmicar.imePrezime != ""){
            config.params.imePrezime =  $scope.trazeniTakmicar.imePrezime;
        }

        if( $scope.trazeniTakmicar.drzava != ""){
            config.params.drzava =  $scope.trazeniTakmicar.drzava;
        }


        $http.get(baseUrlTakmicari, config)
            .then(
            	function success(res){
            		$scope.takmicari = res.data;
            		$scope.totalPages = res.headers('totalPages');
            	},
            	function error(res){
            		alert("Neuspesno dobavljanje takmicara!");
            	}
            );
    };

    var getSkakaonice = function(){

        $http.get(baseUrlSkakaonice)
            .then(
            	function success(res){
            		$scope.skakaonice = res.data;
            	},
            	function error(res){
            		alert("Neuspesno dobavljanje skakaonice!");
            	}
            );

    };

    getTakmicari();
    getSkakaonice();
   

    $scope.nazad = function(){
        if($scope.pageNum > 0) {
            $scope.pageNum = $scope.pageNum - 1;
            getTakmicari();
        }
    };

    $scope.napred = function(){
        if($scope.pageNum < $scope.totalPages - 1){
            $scope.pageNum = $scope.pageNum + 1;
            getTakmicari();
        }
    };

    $scope.dodaj = function(){
    	 $location.path('/takmicar/add');
    };

    $scope.trazi = function () {
        $scope.pageNum = 0;
        getTakmicari();
    }

    $scope.izmeni = function(id){
        $location.path('/takmicar/edit/' + id);
    }

    $scope.obrisi = function(id){
        $http.delete(baseUrlTakmicari + "/" + id).then(
            function success(data){
            	alert("Takmicar je obrisan.");
            	getTakmicari();
            },
            function error(data){
                alert("Neuspesno brisanje!");
            }
        );
    }
    
    $scope.skok = function(id) {
    	$location.path('/takmicar/skok/' + id);
    }
    
 $scope.skokovi = function(id) {
    	$location.path('/takmicar/skokovi/' + id);
    }


});

testApp.controller("skokoviCtrl", function($scope, $http, $location, $routeParams){
	
	var baseUrlTakmicari = "/api/takmicari";
	var baseUrlSkok = "api/skokovi";
	
	$scope.skokovi = [];
	
	var getSkokovi = function() {
		$http.get(baseUrlTakmicari + '/' + $routeParams.id + '/skokovi').then(
				function succes(res){
					$scope.skokovi = res.data;
				},
				function error() {
					alert("Neuspesno dobavljanje skokova.");
				}
		);
	}
	
	getSkokovi();
	
	$scope.zbir = function(id) {
		$http.put(baseUrlSkok + '/' + id + '/skok', $scope.skokovi).then(
				function success() {
				alert("Zbir poena je izracunat.");
				getSkokovi();
				},
				function error() {
					alert("Neuspesno racunanje poena.");
				}
		)
	}
	
	$scope.nazad = function() {
		 $location.path('/');
	}
})

testApp.controller("takmicarAddCtrl", function($scope, $http, $location){
	
	var baseUrlTakmicari = "/api/takmicari";
    var baseUrlSkakaonice = "/api/skakaonice";
    


    $scope.takmicari = [];
    $scope.skakaonice = [];

    $scope.novTakmicar = {};
    $scope.novTakmicar.drzava = "";
    $scope.novTakmicar.visina = "";
    $scope.novTakmicar.godinaRodjenja = "";
    $scope.novTakmicar.email = "";
    $scope.novTakmicar.skakaonicaId = "";
    

    var getSkakaonice = function(){

        $http.get(baseUrlSkakaonice)
            .then(
            	function success(res){
            		$scope.skakaonice = res.data;
            	},
            	function error(res){
            		alert("Neuspesno dobavljanje skakaonice!");
            	}
            );

    };
    
    getSkakaonice();
   

    $scope.dodaj = function(){
        $http.post(baseUrlTakmicari, $scope.novTakmicar)
            .then(
            	function success(res){
            		
            		alert("Takmicar je dodat.");
            		$scope.novTakmicar = {};
            	    $scope.novTakmicar.drzava = "";
            	    $scope.novTakmicar.visina = "";
            	    $scope.novTakmicar.godinaRodjenja = "";
            	    $scope.novTakmicar.email = "";
            	    $scope.novTakmicar.skakaonicaId = "";
            	    
            	    $location.path('/');
            	},
            	function error(res){
            		alert("Neuspesno dodavanje!");
            	}
            );
    };
    
});

testApp.controller("takmicarEditCtrl", function($scope, $http, $routeParams, $location){
	

	var baseUrlTakmicar = "/api/takmicari";
	 var baseUrlSkakaonice = "/api/skakaonice";
	

    $scope.stariTakmicar = null;
    $scope.skakaonice = [];

    var getStariTakmicar = function(){

        $http.get(baseUrlTakmicar + "/" + $routeParams.id)
            .then(
            	function success(res){
            		$scope.stariTakmicar = res.data;
            	},
            	function error(data){
            		alert("Neušpesno dobavljanje takmicara.");
            	}
            );

    }
    
    var getSkakaonice = function(){

        $http.get(baseUrlSkakaonice)
            .then(
            	function success(res){
            		$scope.skakaonice = res.data;
            		 getStariTakmicar();
            	},
            	function error(res){
            		alert("Neuspesno dobavljanje skakaonice!");
            	}
            );

    };
    
    getSkakaonice();
    
    
    
    $scope.izmeni = function(){
        $http.put(baseUrlTakmicar + "/" + $scope.stariTakmicar.id, $scope.stariTakmicar)
            .then(
        		function success(data){
        			alert("Uspešno izmenjen takmicar!");
        			$location.path("/");
        		},
        		function error(data){
        			alert("Neuspešna izmena takmicara.");
        		}
            );
    }
    
});

testApp.controller("skokAddCtrl", function($scope, $http, $location, $routeParams){
	
	var baseUrlSkok = "/api/skokovi";
	
	
    $scope.novSkok = {};
    $scope.novSkok.daljina = "";
    $scope.novSkok.ocenaSudija = "";
    $scope.novSkok.zbirPoena = "";
    $scope.novSkok.takmicarId = $routeParams.id;

    $scope.dodaj = function(){
        $http.post(baseUrlSkok, $scope.novSkok)
            .then(
            	function success(res){
            		
            		alert("Skok je evidentiran.");
            		
            		$scope.novSkok = {};
            	    $scope.novSkok.daljina = "";
            	    $scope.novSkok.ocenaSudija = "";
            	    
            	    $location.path('/');
            		
            	},
            	function error(res){
            		alert("Neuspesno dodavanje!");
            	}
            );
    };
    
});


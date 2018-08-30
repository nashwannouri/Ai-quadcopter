(define (problem Problem1)
	(:domain quadcopter)
	(:objects
		Quad - quadcopter
		Package1 Package2 Package3 - package
		Base - base
		Person1 Person2 Person3 - person
		gripper - gripper
		charge_dock - charge_dock
		c0_0_0 c0_0_1 c0_0_2 c0_1_0 c0_1_1 c0_1_2 c0_2_0 c0_2_1 c0_2_2 c1_0_0 c1_0_1 c1_0_2 c1_1_0 c1_1_1 c1_1_2 c1_2_0 c1_2_1 c1_2_2 c2_0_0 c2_0_1 c2_0_2 c2_1_0 c2_1_1 c2_1_2 c2_2_0 c2_2_1 c2_2_2 - coordinates
	)
	(:init
		(base-at Base c0_0_0)
		(quad-at-base Quad Base)
		(quad-has-camera Quad)
		(quad-gripper-free Quad gripper)
		(charge-dock-at charge_dock c2_1_0)
		
		(package-at Package1 c0_0_0)
		(person-at Person1 c1_1_0)
		
		(= (battery Quad) 7)
		(= (battery-capacity Quad) 20)
		(= (charge-dock-refill-rate charge_dock) 10)	
		
		(path-horizontal c0_0_0 c1_0_0) (path-horizontal c0_0_0 c0_1_0) (path-horizontal c0_0_1 c0_1_1) (path-horizontal c0_0_1 c1_0_1) (path-horizontal c0_0_2 c1_0_2) (path-horizontal c0_0_2 c0_1_2) (path-horizontal c0_1_0 c0_0_0) (path-horizontal c0_1_0 c0_2_0) (path-horizontal c0_1_0 c1_1_0) (path-horizontal c0_1_1 c0_2_1) (path-horizontal c0_1_1 c0_0_1) (path-horizontal c0_1_1 c1_1_1) (path-horizontal c0_1_2 c0_0_2) (path-horizontal c0_1_2 c0_2_2) (path-horizontal c0_1_2 c1_1_2) (path-horizontal c0_2_0 c1_2_0) (path-horizontal c0_2_0 c0_1_0) (path-horizontal c0_2_1 c0_1_1) (path-horizontal c0_2_1 c1_2_1) (path-horizontal c0_2_2 c1_2_2) (path-horizontal c0_2_2 c0_1_2) (path-horizontal c1_0_0 c1_1_0) (path-horizontal c1_0_0 c0_0_0) (path-horizontal c1_0_0 c2_0_0) (path-horizontal c1_0_1 c1_1_1) (path-horizontal c1_0_1 c0_0_1) (path-horizontal c1_0_1 c2_0_1) (path-horizontal c1_0_2 c1_1_2) (path-horizontal c1_0_2 c0_0_2) (path-horizontal c1_0_2 c2_0_2) (path-horizontal c1_1_0 c1_0_0) (path-horizontal c1_1_0 c1_2_0) (path-horizontal c1_1_0 c0_1_0) (path-horizontal c1_1_0 c2_1_0) (path-horizontal c1_1_1 c1_2_1) (path-horizontal c1_1_1 c1_0_1) (path-horizontal c1_1_1 c0_1_1) (path-horizontal c1_1_1 c2_1_1) (path-horizontal c1_1_2 c1_2_2) (path-horizontal c1_1_2 c1_0_2) (path-horizontal c1_1_2 c0_1_2) (path-horizontal c1_1_2 c2_1_2) (path-horizontal c1_2_0 c1_1_0) (path-horizontal c1_2_0 c0_2_0) (path-horizontal c1_2_0 c2_2_0) (path-horizontal c1_2_1 c1_1_1) (path-horizontal c1_2_1 c0_2_1) (path-horizontal c1_2_1 c2_2_1) (path-horizontal c1_2_2 c1_1_2) (path-horizontal c1_2_2 c0_2_2) (path-horizontal c1_2_2 c2_2_2) (path-horizontal c2_0_0 c1_0_0) (path-horizontal c2_0_0 c2_1_0) (path-horizontal c2_0_1 c2_1_1) (path-horizontal c2_0_1 c1_0_1) (path-horizontal c2_0_2 c1_0_2) (path-horizontal c2_0_2 c2_1_2) (path-horizontal c2_1_0 c2_2_0) (path-horizontal c2_1_0 c2_0_0) (path-horizontal c2_1_0 c1_1_0) (path-horizontal c2_1_1 c2_2_1) (path-horizontal c2_1_1 c1_1_1) (path-horizontal c2_1_1 c2_0_1) (path-horizontal c2_1_2 c2_2_2) (path-horizontal c2_1_2 c2_0_2) (path-horizontal c2_1_2 c1_1_2) (path-horizontal c2_2_0 c1_2_0) (path-horizontal c2_2_0 c2_1_0) (path-horizontal c2_2_1 c2_1_1) (path-horizontal c2_2_1 c1_2_1) (path-horizontal c2_2_2 c1_2_2) (path-horizontal c2_2_2 c2_1_2) (path-vertical-up c0_0_0 c0_0_1) (path-vertical-up c0_0_1 c0_0_2) (path-vertical-up c0_1_0 c0_1_1) (path-vertical-up c0_1_1 c0_1_2) (path-vertical-up c0_2_0 c0_2_1) (path-vertical-up c0_2_1 c0_2_2) (path-vertical-up c1_0_0 c1_0_1) (path-vertical-up c1_0_1 c1_0_2) (path-vertical-up c1_1_0 c1_1_1) (path-vertical-up c1_1_1 c1_1_2) (path-vertical-up c1_2_0 c1_2_1) (path-vertical-up c1_2_1 c1_2_2) (path-vertical-down c1_2_2 c1_2_1) (path-vertical-up c2_0_0 c2_0_1) (path-vertical-up c2_0_1 c2_0_2) (path-vertical-up c2_1_0 c2_1_1) (path-vertical-up c2_1_1 c2_1_2) (path-vertical-up c2_2_0 c2_2_1) (path-vertical-up c2_2_1 c2_2_2) (path-vertical-down c0_0_1 c0_0_0) (path-vertical-down c0_0_2 c0_0_1) (path-vertical-down c0_1_1 c0_1_0) (path-vertical-down c0_1_2 c0_1_1) (path-vertical-down c0_2_1 c0_2_0) (path-vertical-down c0_2_2 c0_2_1) (path-vertical-down c1_0_1 c1_0_0) (path-vertical-down c1_0_2 c1_0_1) (path-vertical-down c1_1_1 c1_1_0) (path-vertical-down c1_1_2 c1_1_1) (path-vertical-down c1_2_1 c1_2_0) (path-vertical-down c2_0_1 c2_0_0) (path-vertical-down c2_0_2 c2_0_1) (path-vertical-down c2_1_1 c2_1_0) (path-vertical-down c2_1_2 c2_1_1) (path-vertical-down c2_2_1 c2_2_0) (path-vertical-down c2_2_2 c2_2_1) 
	
		(coordinate-empty c0_0_0) (coordinate-empty c0_0_1) (coordinate-empty c0_0_2) (coordinate-empty c0_1_1) (coordinate-empty c0_1_2) (coordinate-empty c0_2_0) (coordinate-empty c0_2_1) (coordinate-empty c0_2_2) (coordinate-empty c1_0_0) (coordinate-empty c1_0_1) (coordinate-empty c1_0_2) (coordinate-empty c1_1_1) (coordinate-empty c1_1_2) (coordinate-empty c1_2_0) (coordinate-empty c1_2_1) (coordinate-empty c1_2_2) (coordinate-empty c2_0_1) (coordinate-empty c2_0_2) (coordinate-empty c2_1_0) (coordinate-empty c2_1_1) (coordinate-empty c2_1_2) (coordinate-empty c2_2_0) (coordinate-empty c2_2_1) (coordinate-empty c2_2_2) 
	)	
	(:goal (and 
			(picture-taken Person1 Package1) 
			(quad-at-base Quad Base))
	)
	(:metric minimize (total-time))
)

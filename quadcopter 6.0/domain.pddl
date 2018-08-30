(define (domain quadcopter)
	(:requirements :strips :typing :fluents :durative-actions :equality)
	(:types person base quadcopter package charge_dock coordinates gripper)
	(:predicates 
		(path-horizontal ?from ?to - coordinates) 
		(path-vertical-up ?from ?to - coordinates)
		(path-vertical-down ?from ?to - coordinates)
		(package-at ?package - package ?from - coordinates)
		(quad-carry ?quadcopter - quadcopter ?package - package ?gripper - gripper)
		(quad-gripper-free ?quadcopter - quadcopter ?gripper - gripper)
		(quad-at ?quadcopter - quadcopter ?from - coordinates)
		(charge-dock-occupied ?charge_dock - charge_dock ?from - coordinates)
		(charge-dock-at ?charge_dock - charge_dock ?at - coordinates)
		(coordinate-empty ?this - coordinates)
		(quad-has-camera ?quadcopter - quadcopter)
		(person-at ?person - person ?at - coordinates)
		(picture-taken ?person - person ?package - package)
		(base-at ?base - base ?at - coordinates)
		(quad-at-base ?quadcopter - quadcopter ?base - base)
	)

	(:functions 
		(battery ?quadcopter - quadcopter)
		(battery-capacity ?quadcopter - quadcopter)
		(charge-dock-refill-rate ?charge_dock - charge_dock)
	)

	(:durative-action take-off
		:parameters(?quadcopter - quadcopter ?base - base ?at - coordinates)
		:duration(= ?duration 1)
		:condition(and
			(at start (base-at ?base ?at))
			(at start (quad-at-base ?quadcopter ?base))
			(over all (> (battery ?quadcopter) 0))
			
		)
		:effect(and
			(at start (not (quad-at-base ?quadcopter ?base)))
			(at start (quad-at ?quadcopter ?at))
			(at end (decrease(battery ?quadcopter) 1))
		)
	)
	
	(:durative-action refill
		:parameters(?at - coordinates ?quadcopter - quadcopter ?charge_dock  - charge_dock)
		:duration(= ?duration 1)
		:condition(and
			(at start (charge-dock-at ?charge_dock ?at)) 
			(at start (quad-at ?quadcopter ?at))
			(over all (<=(battery ?quadcopter) (battery-capacity ?quadcopter)))
		) 
		:effect(and
			(at start (charge-dock-occupied ?charge_dock ?at))
			(at end (increase (battery ?quadcopter)(charge-dock-refill-rate ?charge_dock))) 
			(at end (not (charge-dock-occupied ?charge_dock ?at)))
		)
	)
	
	(:durative-action land
		:parameters(?quadcopter - quadcopter ?base - base ?at - coordinates ?gripper -gripper)
		:duration(= ?duration 1)
		:condition(and
			(at start (quad-at ?quadcopter ?at))		
			(at start (base-at ?base ?at))
			(at start (quad-gripper-free ?quadcopter ?gripper))
			(over all (> (battery ?quadcopter) 0))
		)
		:effect(and
			(at end (quad-at-base ?quadcopter ?base))
			(at start (not (quad-at ?quadcopter ?at)))
			(at end (decrease(battery ?quadcopter) 1))
		)
	)
	
	(:durative-action loadpackage
		:parameters(?from - coordinates ?package - package ?quadcopter - quadcopter ?gripper - gripper )
		:duration(= ?duration 2)
		:condition(and
			(at start (quad-at ?quadcopter ?from))
			(at start (package-at ?package ?from))  
			(at start (quad-gripper-free ?quadcopter ?gripper))
			(over all (> (battery ?quadcopter) 0))	
		)
		:effect(and
			(at start (not(package-at ?package ?from)))
	       	(at start (not(quad-gripper-free ?quadcopter ?gripper)))
			(at end (decrease(battery ?quadcopter) 1))
		   	(at start (quad-carry ?quadcopter ?package ?gripper))
		)
	)

	(:durative-action deliver-package
		:parameters(?from ?at - coordinates ?package - package ?quadcopter - quadcopter ?gripper - gripper ?person -person)
		:duration(= ?duration 2)
		:condition(and
			(at start(quad-at ?quadcopter ?from))
			(at start(quad-carry ?quadcopter ?package ?gripper))
			(at start (path-vertical-down ?from ?at))
			(at start (person-at ?person ?at))
			(over all (quad-has-camera ?quadcopter))
			(over all (> (battery ?quadcopter) 0))	

		)
		:effect(and
			(at start (package-at ?package ?at))
			(at start (quad-gripper-free ?quadcopter ?gripper))
			(at start (not(quad-carry ?quadcopter ?package ?gripper)))
			(at end (picture-taken ?person ?package))
			(at end (decrease(battery ?quadcopter) 1))  
		)
	)
	
	(:durative-action move-horizontal
		:parameters(?from ?to - coordinates ?quadcopter - quadcopter)
		:duration(= ?duration 1)
		:condition(and
			(at start (path-horizontal ?from ?to)) 
			(at start (quad-at ?quadcopter ?from))
			(at start (coordinate-empty ?to))
			(over all ( > (battery ?quadcopter) 0))
		) 
		:effect(and	
			(at start (not (quad-at ?quadcopter ?from)))
			(at end (quad-at ?quadcopter ?to))
			(at end (not (coordinate-empty ?to)))
			(at end (coordinate-empty ?from))
			(at end (decrease(battery ?quadcopter) 1))
		)
	)

	(:durative-action ascend
		:parameters(?from ?to - coordinates ?quadcopter - quadcopter)
		:duration(= ?duration 1)
		:condition(and
			(at start (path-vertical-up ?from ?to)) 
			(at start (quad-at ?quadcopter ?from))
			(at start (coordinate-empty ?to))
			(over all (> (battery ?quadcopter) 0))
		)
		:effect(and
			(at start (not(quad-at ?quadcopter ?from)))
			(at end (quad-at ?quadcopter ?to))
			(at end (not (coordinate-empty ?to)))
			(at end (coordinate-empty ?from))
			(at end (decrease(battery ?quadcopter)1))
		)
	)

	(:durative-action descend
		:parameters(?from ?to - coordinates ?quadcopter - quadcopter)
		:duration(= ?duration 1)
		:condition(and
			(at start (path-vertical-down ?from ?to))
			(at start (quad-at ?quadcopter ?from))
			(at start (coordinate-empty ?to))
		   	(over all (> (battery ?quadcopter) 0))
		)
		:effect(and
			(at start(not(quad-at ?quadcopter ?from)))
		  	(at end(quad-at ?quadcopter ?to))
			(at end (not (coordinate-empty ?to)))
			(at end (coordinate-empty ?from))
			(at end (decrease(battery ?quadcopter) 1))
		)
	)

)

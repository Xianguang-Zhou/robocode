/*******************************************************************************
 * Copyright (c) 2001, 2008 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/cpl-v10.html
 *
 * Contributors:
 *     Mathew A. Nelson
 *     - Initial API and implementation
 *     Flemming N. Larsen
 *     - Updated Javadocs
 *******************************************************************************/
package robocode;


import robocode.peer.RobotStatics;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;

import java.awt.*;


/**
 * This event is sent to {@link Robot#onDeath(DeathEvent) onDeath()} when your
 * robot dies.
 *
 * @author Mathew A. Nelson (original)
 */
public final class DeathEvent extends Event {
	private final static int DEFAULT_PRIORITY = -1; // System event -> cannot be changed!;

	/**
	 * Called by the game to create a new DeathEvent.
	 */
	public DeathEvent() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPriority() {
		return DEFAULT_PRIORITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	final int getDefaultPriority() {
		return DEFAULT_PRIORITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	final void dispatch(IBasicRobot robot, RobotStatics statics, Graphics2D graphics) {
		IBasicEvents listener = robot.getBasicEventListener();

		if (listener != null) {
			listener.onDeath(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	final boolean isCriticalEvent() {
		return true;
	}
}
